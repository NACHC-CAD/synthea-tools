package org.nachc.tools.synthea.util.fhir;

import org.hl7.fhir.dstu3.model.Patient;

public class PatientParser {

	private Patient patient;
	
	public PatientParser(Patient patient) {
		this.patient = patient;
	}
	
	public String getId() {
		String patientId = patient.getIdElement().getIdPart();
		return patientId;
	}
	
}
