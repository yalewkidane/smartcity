package org.gs1.smartcity.capturing.services.query;

public class ErrorProcessor {
	
	public static final String URL_ERROR = "urlError";
	public static final String CLIENT_ERROR = "clientError";
	public static final String SERVER_ERROR = "serverError";
	
	public void process(String errorType) {
		
		if(errorType.equals(URL_ERROR)) {
			processUrlError();
		} else if(errorType.equals(CLIENT_ERROR)) {
			processClientError();
		} else if(errorType.equals(SERVER_ERROR)) {
			processServerError();
		}
	}
	
	private void processUrlError() {
		
		
	}
	
	private void processClientError() {
		
		
	}
	
	private void processServerError() {
		
		
	}

}
