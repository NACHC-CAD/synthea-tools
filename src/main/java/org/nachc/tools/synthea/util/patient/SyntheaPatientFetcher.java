package org.nachc.tools.synthea.util.patient;

import org.nachc.tools.synthea.util.params.SyntheiaAuthParams;

import com.nach.core.util.http.HttpRequestClient;
import com.nach.core.util.oauth.OauthTokenFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyntheaPatientFetcher {

	private HttpRequestClient client;
	
	public HttpRequestClient getClient() {
		return this.client;
	}
	
	public int getStatusCode() {
		return this.client.getStatusCode();
	}
	
	public String getToken() {
		String url = SyntheiaAuthParams.getOauthUrl();
		String uid = SyntheiaAuthParams.getAppId();
		String secret = SyntheiaAuthParams.getSecret();
		String[] accept = new String[] {"Accept", "application/json"};
		String[] contentType = new String[] {"Content-Type", "application/json"};
		String[][] headers = new String[][] {accept, contentType};
		String msg = "{ \"grantType\" : \"client_credentials\", \"scopes\" : \"user/*.read\" }";
		return OauthTokenFactory.getToken(url, uid, secret, headers, msg);
	}
	
	public String fetchPatients(int howMany) {
		String url = SyntheiaAuthParams.getUrl();
		String key = SyntheiaAuthParams.getKey();
		url += "/Patient?";
		url += "_count=" + howMany;
		url += "&apikey=" + key;
		log.info("URL: " + url);
		this.client = new HttpRequestClient(url);
		client.doGet();
		int status = client.getStatusCode();
		log.info("Got status: " + status);
		String response = client.getResponse();
		log.info("Response length: " + response.length());
		return response;
	}
	
	public static String getNext(String url) {
		String key = SyntheiaAuthParams.getKey();
		url += "&apikey=" + key;
		HttpRequestClient client = new HttpRequestClient(url);
		client.doGet();
		int status = client.getStatusCode();
		log.info("Got status: " + status);
		String response = client.getResponse();
		log.info("Response length: " + response.length());
		return response;
	}
	
	public String fetchEverything(String patientId) {
		String url = SyntheiaAuthParams.getUrl();
		String key = SyntheiaAuthParams.getKey();
		url += "/Patient/" + patientId + "/$everything?";
		url += "apikey=" + key;
		log.info("URL: " + url);
		this.client = new HttpRequestClient(url);
		client.doGet();
		int status = client.getStatusCode();
		log.info("Got status: " + status);
		String response = client.getResponse();
		log.info("Response length: " + response.length());
		return response;
	}
	
}
