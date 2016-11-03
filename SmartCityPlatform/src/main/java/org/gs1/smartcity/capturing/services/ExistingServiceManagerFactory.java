package org.gs1.smartcity.capturing.services;

import org.gs1.smartcity.capturing.ServiceFactory;
import org.gs1.smartcity.capturing.services.bus.BusServiceManager;

public class ExistingServiceManagerFactory {
	
public ExistingServiceManager getManager(String type) {
		
		ExistingServiceManager manager = null;
		
		if(type.equals(ServiceFactory.BUS)) {
			
			manager = new BusServiceManager();
		}
		
		return manager;
		
	}

}
