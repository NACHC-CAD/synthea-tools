package org.nachc.tools.synthea.unittestintegrationtest.bundle;

import java.util.List;

import org.hl7.fhir.dstu3.model.Patient;
import org.junit.Test;
import org.nachc.tools.synthea.util.fhir.BundleParser;
import org.nachc.tools.synthea.util.fhir.PatientParser;
import org.nachc.tools.synthea.util.patient.SyntheaPatientFetcher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetResourceTypesIntegrationTest {

	@Test
	public void shouldGetTypes() {
		log.info("Starting test...");
		log.info("Getting patient list from synthia...");
		String patientJson = new SyntheaPatientFetcher().fetchPatients(1);
		Patient fhirPatient = new BundleParser(patientJson).getPatients().get(0);
		PatientParser patient = new PatientParser(fhirPatient);
		log.info("Got response:\n" + patientJson);
		log.info("Parsing types...");
		List<String> types = new BundleParser(patientJson).getResourceTypes();
		log.info("Got " + types.size() + " types");
		log.info("Done.");
	}

}
