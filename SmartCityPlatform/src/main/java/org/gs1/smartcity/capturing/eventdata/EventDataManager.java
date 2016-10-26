package org.gs1.smartcity.capturing.eventdata;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.smartcity.capturing.DataManager;
import org.gs1.smartcity.capturing.EPCISEventMarshaller;

public abstract class EventDataManager extends DataManager {
	
	protected EPCISEventMarshaller marshaller;
	protected EventListType eventList;
	
	public EventDataManager() {
		
		marshaller = new EPCISEventMarshaller();
		eventList = new EventListType();
	}
	
	public int registerEPCIS(String data) {

		String url = "http://" + epcis_ip + ":8080/epcis/Service/EventCapture";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		try {
			post.setEntity(new StringEntity(data));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
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
