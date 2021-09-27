package org.nachc.tools.synthea.util.patient;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetPatientsIntegrationTest {

	@Test
	public void shouldGetPatients() {
		log.info("Starting test..");
		String response = GetPatients.exec(10);
		log.info("Got response (length):" + response.length());
		log.info("Response:\n" + response);
		log.info("Done.");
	}
	
}
