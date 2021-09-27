package org.nachc.tools.synthea.tools;

import java.io.File;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent;
import org.nachc.tools.synthea.util.patient.GetPatients;

import com.nach.core.util.file.FileUtil;
import com.nach.core.util.json.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WritePatientsToFileTool {

	private static final String ROOT_DIR_NAME = "C:\\test\\synthea-patients";
	
	private static final int PAGE_SIZE = 1000;
	
	private static final int MAX = 1500;
	
	public static void main(String[] args) {
		log.info("Writing patients to file..");
		File root = new File(ROOT_DIR_NAME);
		if(root.exists()) {
			root.delete();
		}
		root = FileUtil.mkdirs(new File(ROOT_DIR_NAME));
		// get the first response
		log.info("----------------------");
		String response = GetPatients.exec(PAGE_SIZE);
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
		while(cnt < MAX && next != null) {
			log.info("----------------------");
			log.info("Getting next set of patients (" + cnt + " of " + MAX + ")");
			cnt++;
			String url = next.getUrl();
			log.info("Got url: " + url);
			response = GetPatients.getNext(url);
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
