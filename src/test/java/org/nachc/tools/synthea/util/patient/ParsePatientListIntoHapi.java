package org.nachc.tools.synthea.util.patient;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hl7.fhir.dstu3.model.Patient;
import org.junit.Test;
import org.nachc.tools.synthea.util.fhir.BundleParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParsePatientListIntoHapi {

	@Test
	public void shouldGetPatients() {
		log.info("Starting test..");
		int cnt = 5;
		String response = new SyntheaPatientFetcher().exec(cnt);
		log.info("Got response (length):" + response.length());
		log.info("Response (for some reason the response doesn't print in eclipse, copy and paste into a text editor if you don't see the response):\n" + response);
		log.info("Parsing into Hapi Bundle object");
		BundleParser bundle = new BundleParser(response);
		List<Patient> patients = bundle.getPatients();
		log.info("Got " + patients.size() + " patients (expecting " + cnt + ")");
		assertTrue(patients.size() == cnt);
		log.info("Done.");
	}

}
