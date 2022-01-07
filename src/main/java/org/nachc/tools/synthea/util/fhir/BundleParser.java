package org.nachc.tools.synthea.util.fhir;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.model.ResourceType;

import com.nach.core.util.json.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BundleParser {

	private String jsonString;
	
	private Bundle bundle;
	
	public BundleParser(String bundleJson) {
		this.jsonString = bundleJson;
		this.bundle = JsonParser.parse(bundleJson, Bundle.class);
	}
	
	public List<Patient> getPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		List<BundleEntryComponent> entries = bundle.getEntry();
		for(BundleEntryComponent entry : entries) {
			ResourceType type = entry.getResource().getResourceType();
			Resource resource = entry.getResource();
			if(resource instanceof Patient) {
				patients.add((Patient) resource);
			}
		}
		return patients;
	}

	public List<String> getResourceTypes() {
		List<String> types = new ArrayList<String>();
		List<BundleEntryComponent> entries = bundle.getEntry();
		for(BundleEntryComponent entry : entries) {
			String type = entry.fhirType();
			types.add(type);
		}
		return types;
	}
	
}
