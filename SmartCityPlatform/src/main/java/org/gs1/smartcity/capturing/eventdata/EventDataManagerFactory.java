package org.gs1.smartcity.capturing.eventdata;

import org.gs1.smartcity.capturing.ServiceFactory;
import org.gs1.smartcity.capturing.eventdata.bus.BusEventDataManager;

public class EventDataManagerFactory {

	public EventDataManager getManager(String type) {
		
		EventDataManager manager = null;
		
		if(type.equals(ServiceFactory.BUS)) {
			
			manager = new BusEventDataManager();
		}
		
		return manager;
	}
}
