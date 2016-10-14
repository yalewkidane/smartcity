package org.gs1.smartcity.capturing.services;

public class ServiceUrlFactory {
	
	public static final String BUSAN_BUS = "busanBus";

	public UrlGenerator getUrlGenerator(String type) {

		UrlGenerator urlGenerator = null;

		if(type.equals(BUSAN_BUS)) {

			urlGenerator = new BusanBusUrlGenerator();
		}

		return urlGenerator;

	}

}
