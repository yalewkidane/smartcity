package org.gs1.smartcity.capturing.services;

import org.gs1.smartcity.capturing.ServiceFactory;
import org.gs1.smartcity.capturing.services.bus.BusEventTranslator;

public class EventTransFactory {

	public EventTranslator getTrans(String type) {
		
		EventTranslator trans = null;

		if(type.equals(ServiceFactory.BUS)) {

			trans = new BusEventTranslator();
		}

		return trans;
	}

}
