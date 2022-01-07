package org.nachc.tools.synthea.util.patient;

import java.io.File;

import org.junit.Test;

import com.nach.core.util.file.FileUtil;
import com.nach.core.util.json.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WritePatientsToFileIntegrationTest {

	@Test
	public void shouldGetPatients() {
		log.info("Starting test..");
		String response = new SyntheaPatientFetcher().fetchPatients(5);
		log.info("Got response (length):" + response.length());
		response = JsonUtil.prettyPrint(response);
		log.info("Response (for some reason the response doesn't print in eclipse, copy and paste into a text editor if you don't see the response):\n" + response);
		File file = new File("/test/synthea-tools/test-patient.json");
		FileUtil.mkdirs(file.getParentFile());
		log.info("Writing patient to file: " + FileUtil.getCanonicalPath(file));
		FileUtil.write(response, file);
		log.info("Done.");
	}
	
	
}
