package org.nachc.tools.synthea.util.patient;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent;
import org.junit.Test;

import com.nach.core.util.json.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetPatientsPagingIntegrationTest {

	@Test
	public void shouldGetPatients() {
		log.info("Starting test..");
		String response = GetPatients.exec(10);
		log.info("Got response (length):" + response.length());
		log.info("Creating hapi object...");
		Bundle bundle = JsonParser.parse(response, Bundle.class);
		log.info("Got Hapi Object: " + bundle);
		BundleLinkComponent next = bundle.getLink("next");
		log.info("Got next: " + next);
		String url = next.getUrl();
		log.info("Got url: " + url);
		response = GetPatients.getNext(url);
		log.info("Got response (length):" + response.length());
		log.info("Done.");
	}
	
}
