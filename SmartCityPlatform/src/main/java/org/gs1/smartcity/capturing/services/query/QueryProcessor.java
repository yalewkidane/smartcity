package org.gs1.smartcity.capturing.services.query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class QueryProcessor {

	public String query(String url) throws IOException {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.connect();

		int responseCode = con.getResponseCode();
		if(responseCode != 200) {
			System.out.println("Failed : HTTP error code : " + con.getResponseCode());
			
			if(responseCode >= 400 && responseCode < 500) {
				return ErrorProcessor.CLIENT_ERROR;
			} else if(responseCode >= 500) {
				return ErrorProcessor.SERVER_ERROR;
			}
		}

		//Print response headers
		System.out.println("\nResponse Headers:\n");
		Map<String, List<String>> map = con.getHeaderFields();
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		//Get response body and print it
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String output;
		StringBuffer response = new StringBuffer();


		while ((output = br.readLine()) != null) {
			response.append(output);
			if(output.compareTo("") != 0) {
				response.append("\n");
			}
		}
		br.close();

		con.disconnect();

		return response.toString();

	}

}
