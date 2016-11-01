package org.gs1.smartcity.capturing;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public abstract class DataManager {

	protected static final String PROPERTY_PATH = "smartcity.properties";

	protected static String epcis_ip;
	protected static String epcis_port;

	public DataManager() {

		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream(PROPERTY_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}

		epcis_ip = prop.getProperty("epcis_ip");
		epcis_port = prop.getProperty("epcis_port");
	}

	public abstract String modeling(String type, Object object);

	public int registerEPCIS(String data) {

		String url = "http://" + epcis_ip + ":" + epcis_port + "/epcis/Service/EventCapture";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		post.setEntity(new StringEntity(data, "UTF-8"));

		HttpResponse response = null;
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response.getStatusLine().getStatusCode();
	}

}
