package org.gs1.smartcity.capturing.services;

import javax.xml.parsers.ParserConfigurationException;

import org.gs1.smartcity.capturing.services.bus.BusEventTranslator;

public class EventTransFactory {

	public EventTranslator getTrans(String type) {
		
		EventTranslator trans = null;

		if(type.equals(ServiceFactory.BUS)) {

			try {
				trans = new BusEventTranslator();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}

		return trans;
	}

}
