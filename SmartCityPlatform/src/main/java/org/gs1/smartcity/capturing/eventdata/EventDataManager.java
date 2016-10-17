package org.gs1.smartcity.capturing.eventdata;

import org.gs1.epcglobal.epcis.ObjectEventType;

public abstract class EventDataManager {
	
	public abstract ObjectEventType modelingObjectEvent(String type, Object data);
	
}
