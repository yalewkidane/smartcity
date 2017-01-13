package org.gs1.smartcity.capturing.eventdata;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.smartcity.capturing.DataManager;

public abstract class EventDataManager extends DataManager {
	
	protected EPCISEventMarshaller marshaller;
	protected EventListType eventList;
	
	public EventDataManager() {
		
		marshaller = new EPCISEventMarshaller();
		eventList = new EventListType();
	}
	
}
