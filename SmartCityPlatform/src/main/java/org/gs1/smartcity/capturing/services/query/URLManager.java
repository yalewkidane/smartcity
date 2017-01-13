package org.gs1.smartcity.capturing.services.query;

import java.util.List;

import org.gs1.smartcity.datatype.ParameterType;
import org.gs1.smartcity.datatype.url.ServiceUrlDetailType;
import org.gs1.smartcity.db.mongo.capturing.ServiceUrlDAO;

public class URLManager {
	
	private ServiceUrlDAO serviceUrlDAO;
	
	public URLManager() {
		
		serviceUrlDAO = new ServiceUrlDAO();
	}
	
	public String getServiceUrl(String serviceName, String infoType, List<ParameterType> params) {
		
		String serviceUrl = null;
		
		String baseUrl = serviceUrlDAO.queryServiceName(serviceName);
		if(baseUrl == null) {
			System.out.println("Error: " + serviceName + " is not registered.");
			return ErrorProcessor.URL_ERROR;
		}
		
		ServiceUrlDetailType serviceUrlDetail = serviceUrlDAO.queryInfoType(serviceName, infoType);
		if(serviceUrlDetail == null) {
			System.out.println("Error: " + infoType + " is not valid query type.");
			return ErrorProcessor.URL_ERROR;
		}
		
		int numOfParams = params.size();
		if(numOfParams != serviceUrlDetail.getNumOfParams()) {
			System.out.println("Error: parameters are not valid");
			return ErrorProcessor.URL_ERROR;
		}
		
		serviceUrl = baseUrl + serviceUrlDetail.getInfoUrl();
		
		for(int i = 0; i < numOfParams; i ++) {
			ParameterType p = params.get(i);
			serviceUrl = serviceUrl + p.getName() + "=" + p.getValue();
			
			if(i != numOfParams - 1) {
				serviceUrl = serviceUrl + "&";
			}
		}
		
		return serviceUrl;
	}

}
