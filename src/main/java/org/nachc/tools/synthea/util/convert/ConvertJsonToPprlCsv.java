package org.nachc.tools.synthea.util.convert;

import java.util.List;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Resource;

import com.nach.core.util.fhir.resource.PatientUtil;
import com.nach.core.util.json.JsonParser;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ConvertJsonToPprlCsv {

	private int lastRecordNumber;

	public String exec(String json, int firstRecordNumber) {
		String rtn = "";
		rtn += getHeaderRow() + "\n";
		log.info("parsing json");
		Bundle bundle = JsonParser.parse(json, Bundle.class);
		log.info("got bundle");
		List<BundleEntryComponent> list = bundle.getEntry();
		int total = list.size();
		log.info("got " + total + " entries");
		int currentRecordNumber = firstRecordNumber;
		for (BundleEntryComponent comp : list) {
			Resource resource = comp.getResource();
			if (resource != null) {
				String fhirType = resource.fhirType();
				if ("Patient".equals(fhirType)) {
					Patient patient = (Patient) resource;
					String patientCsv = getPatientAsPprlCsv(currentRecordNumber, patient);
					rtn += patientCsv + "\n";
					currentRecordNumber++;
				}
			} else {
				continue;
			}
		}
		return rtn;
	}

	private String getHeaderRow() {
		String rtn = "record_id, given_name, family_name, DOB, sex, phone_number, household_street_address, household_zip, parent_given_name, parent_family_name, parent_email";
		return rtn;
	}

	private String getPatientAsPprlCsv(int recordId, Patient patient) {
		String rtn = "";
		rtn += recordId + ",";
		rtn += PatientUtil.getGivenName(patient) + ",";
		rtn += PatientUtil.getFamilyName(patient) + ",";
		rtn += PatientUtil.getDateOfBirth(patient) + ",";
		return rtn;
	}

}
