package org.gs1.smartcity.capturing.eventdata;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.gs1.smartcity.capturing.services.ExistingServiceManager;
import org.gs1.smartcity.capturing.services.ExistingServiceManagerFactory;

public class EventCapturer extends TimerTask {
	
	private ExistingServiceManager serviceManager;
	private String serviceName;
	private String serviceType;
	private List<String> params;
	
	public EventCapturer(String serviceClass, String serviceName, String serviceType, List<String> params) {
		
		serviceManager = (new ExistingServiceManagerFactory()).getManager(serviceClass);
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.params = new ArrayList<String>();
		this.params.addAll(params);
	}
	
	public void run() {
		
		String eventData = serviceManager.queryExistingServiceEvent(serviceName, serviceType, params);
		serviceManager.registerEventData(eventData);
		
	}

}
