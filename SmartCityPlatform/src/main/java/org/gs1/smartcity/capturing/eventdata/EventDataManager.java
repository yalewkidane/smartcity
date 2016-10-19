package org.gs1.smartcity.capturing.eventdata;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.gs1.epcglobal.epcis.ObjectEventType;

public abstract class EventDataManager {
	
	public abstract ObjectEventType modelingObjectEvent(String type, Object data);
	
	public void registerEPCIS(String data) throws IOException {

		String url = "http://143.248.56.100:8080/epcis/Service/EventCapture";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		post.setEntity(new StringEntity(data));
		
		HttpResponse response = client.execute(post);
		
		System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

	}
}
