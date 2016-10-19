package org.gs1.smartcity.capturing.services;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.smartcity.capturing.eventdata.EventDataManager;

public abstract class EventTranslator {
	
	protected EventDataManager edm;

	public abstract EventListType translate(String type, String data);

}
