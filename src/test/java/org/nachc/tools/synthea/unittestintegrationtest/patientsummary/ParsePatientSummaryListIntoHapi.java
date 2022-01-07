package org.nachc.tools.synthea.unittestintegrationtest.patientsummary;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hl7.fhir.dstu3.model.Patient;
import org.junit.Test;
import org.nachc.tools.synthea.util.fhir.BundleParser;
import org.nachc.tools.synthea.util.fhir.PatientParser;
import org.nachc.tools.synthea.util.patient.SyntheaPatientFetcher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParsePatientSummaryListIntoHapi {

	@Test
	public void shouldGetPatients() {
		log.info("Starting test..");
		int cnt = 5;
		String response = new SyntheaPatientFetcher().fetchPatients(cnt);
		log.info("Got response (length):" + response.length());
		log.info("Response (for some reason the response doesn't print in eclipse, copy and paste into a text editor if you don't see the response):\n" + response);
		log.info("Parsing into Hapi Bundle object");
		BundleParser bundle = new BundleParser(response);
		List<Patient> patients = bundle.getPatients();
		log.info("Got " + patients.size() + " patients (expecting " + cnt + ")");
		assertTrue(patients.size() == cnt);
		for (Patient fhirPatient : patients) {
			log.info("--------------------------------");
			PatientParser patient = new PatientParser(fhirPatient);
			String patientId = patient.getId();
			log.info("Got Patient ID: " + patientId);
		}
		log.info("Done.");
	}

}
