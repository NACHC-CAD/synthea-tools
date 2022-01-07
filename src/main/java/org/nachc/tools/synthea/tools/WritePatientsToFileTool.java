package org.nachc.tools.synthea.tools;

import java.io.File;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent;
import org.nachc.tools.synthea.util.patient.SyntheaPatientFetcher;

import com.nach.core.util.file.FileUtil;
import com.nach.core.util.json.JsonParser;

import lombok.extern.slf4j.Slf4j;

/** 
 * 
 * This class was created to write the raw json comming from synthea to a data file
 * 
 * TODO: JEG - Need to write integration test(s) for this.  
 *
 */

@Slf4j
public class WritePatientsToFileTool {

	public void writeFiles(String targetDirectory, int patientsPerRequest, int maxNumberOfRequests) {
		log.info("Writing patients to file..");
		File root = new File(targetDirectory);
		if(root.exists()) {
			root.delete();
		}
		root = FileUtil.mkdirs(new File(targetDirectory));
		// get the first response
		log.info("----------------------");
		String response = new SyntheaPatientFetcher().fetchPatients(patientsPerRequest);
		log.info("Got response (length):" + response.length());
		log.info("Creating hapi object...");
		Bundle bundle = JsonParser.parse(response, Bundle.class);
		log.info("Got Hapi Object: " + bundle);
		BundleLinkComponent next = bundle.getLink("next");
		log.info("Got next: " + next);
		int cnt = 1;
		FileUtil.write(response, new File(root, "segment-" + cnt + ".json"));
		// get the rest
		int errorCount = 0;
		while(cnt < maxNumberOfRequests && next != null) {
			log.info("----------------------");
			log.info("Getting next set of patients (" + cnt + " of " + maxNumberOfRequests + ")");
			cnt++;
			String url = next.getUrl();
			log.info("Got url: " + url);
			response = SyntheaPatientFetcher.getNext(url);
			log.info("Got response (length):" + response.length());
			try {
				bundle = JsonParser.parse(response, Bundle.class);
				next = bundle.getLink("next");
				FileUtil.write(response, new File(root, "segment-" + cnt + ".json"));
			} catch(Exception exp) {
				log.info("------GOT AN ERROR------");
				errorCount++;
			}
		}
		log.info("Got " + errorCount + " errors");
		log.info("Done.");
		
	}
	
}
