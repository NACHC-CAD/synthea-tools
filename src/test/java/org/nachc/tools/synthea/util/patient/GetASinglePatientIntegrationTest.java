package org.nachc.tools.synthea.util.patient;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetASinglePatientIntegrationTest {

	@Test
	public void shouldGetPatients() {
		log.info("Starting test..");
		String response = new SyntheaPatientFetcher().fetchPatients(1);
		log.info("Got response (length):" + response.length());
		log.info("Response (for some reason the response doesn't print in eclipse, copy and paste into a text editor if you don't see the response):\n" + response);
		log.info("Done.");
	}
	
	
}
