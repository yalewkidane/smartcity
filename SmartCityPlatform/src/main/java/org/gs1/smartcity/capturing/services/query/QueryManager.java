package org.gs1.smartcity.capturing.services.query;

import java.io.IOException;
import java.util.List;

import org.gs1.smartcity.datatype.ParameterType;

public class QueryManager {
	
	protected URLManager urlManager;
	protected QueryProcessor queryProcessor;
	protected ErrorProcessor errorProcessor;
	
	public QueryManager() {
		
		urlManager = new URLManager();
		queryProcessor = new QueryProcessor();
		errorProcessor = new ErrorProcessor();
	}
	
	public String queryToService(String serviceName, String infoType, List<ParameterType> params) {
		
		String serviceUrl = urlManager.getServiceUrl(serviceName, infoType, params);
		if(serviceUrl == ErrorProcessor.URL_ERROR) {
			errorProcessor.process(ErrorProcessor.URL_ERROR);
			return null;
		}
		
		String data = null;
		try {
			data = queryProcessor.query(serviceUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(data == ErrorProcessor.CLIENT_ERROR) {
			errorProcessor.process(ErrorProcessor.CLIENT_ERROR);
			return null;
		} else if(data == ErrorProcessor.SERVER_ERROR) {
			errorProcessor.process(ErrorProcessor.SERVER_ERROR);
			return null;
		}
		
		return data;
		
	}

}
