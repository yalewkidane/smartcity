package org.gs1.smartcity.capturing.services;

import org.gs1.smartcity.capturing.services.bus.BusUrlGenerator;

public class ServiceUrlFactory {

	public UrlGenerator getUrlGenerator(String type) {

		UrlGenerator urlGenerator = null;

		if(type.equals(ServiceFactory.BUSAN_BUS)) {

			urlGenerator = new BusUrlGenerator(type);
		}

		return urlGenerator;

	}

}
