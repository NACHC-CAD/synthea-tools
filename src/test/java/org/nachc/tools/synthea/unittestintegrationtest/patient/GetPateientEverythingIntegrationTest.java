package org.nachc.tools.synthea.unittestintegrationtest.patient;

import java.io.File;

import org.hl7.fhir.dstu3.model.Patient;
import org.junit.Test;
import org.nachc.tools.synthea.unittesttools.TestingParams;
import org.nachc.tools.synthea.util.fhir.BundleParser;
import org.nachc.tools.synthea.util.fhir.PatientParser;
import org.nachc.tools.synthea.util.patient.SyntheaPatientFetcher;

import com.nach.core.util.file.FileUtil;
import com.nach.core.util.json.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetPateientEverythingIntegrationTest {

	@Test
	public void shouldGetPatient() {
		log.info("Starting test...");
		log.info("Done.");
		String patientJson = new SyntheaPatientFetcher().fetchPatients(1);
		Patient fhirPatient = new BundleParser(patientJson).getPatients().get(0);
		PatientParser patient = new PatientParser(fhirPatient);
		String patientId = patient.getId();
		log.info("Got patient: " + patientId);
		log.info("Getting everything...");
		SyntheaPatientFetcher synthia = new SyntheaPatientFetcher();
		String everythingJson = synthia.fetchEverything(patientId);
		log.info("Status: " + synthia.getStatusCode());
		log.info("Got response: \n" + JsonUtil.prettyPrint(everythingJson) + "\n\n");
		log.info("Status: " + synthia.getStatusCode());
		File file = TestingParams.getOutFile("everything-patient.json");
		log.info("Writing file to: " + FileUtil.getCanonicalPath(file));
		FileUtil.write(JsonUtil.prettyPrint(everythingJson), file);
		log.info("Done.");
	}

}
