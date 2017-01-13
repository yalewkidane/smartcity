package org.gs1.smartcity.capturing.eventdata;

import java.math.BigDecimal;
import java.util.Calendar;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.smartcity.capturing.EPCISMarshaller;

public class EPCISEventMarshaller extends EPCISMarshaller {

	public EPCISEventMarshaller() {
		
		epcisDoc.setEPCISBody(epcisBody);
		epcisDoc.setCreationDate(Calendar.getInstance());
		epcisDoc.setSchemaVersion(new BigDecimal("1.2"));
	}

	public void make(EventListType eventList) {
		
		epcisBody.setEventList(eventList);
	}

}
