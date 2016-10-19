package org.gs1.smartcity.capturing.masterdata;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.gs1.epcglobal.epcis.VocabularyType;

public abstract class MasterDataManager {

	public abstract VocabularyType modelingVocabulary(String type, Object object);

	public void registerEPCIS(String data) throws IOException {

		String url = "http://143.248.56.100:8080/epcis/Service/VocabularyCapture";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		post.setEntity(new StringEntity(data));
		
		HttpResponse response = client.execute(post);
		
		System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

	}

}