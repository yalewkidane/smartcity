package org.gs1.smartcity.capturing.services;

import org.gs1.smartcity.capturing.services.bus.BusUrlGenerator;

public class UrlGeneratorFactory {
	
public UrlGenerator getUrlGenerator(String type) {
		
		UrlGenerator gen = null;
		
		if(type.equals(ServiceFactory.BUS)) {
			
			gen = new BusUrlGenerator();
		}
		
		return gen;
		
	}

}
