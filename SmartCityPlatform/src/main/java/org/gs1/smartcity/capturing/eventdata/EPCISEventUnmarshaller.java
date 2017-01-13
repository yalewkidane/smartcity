package org.gs1.smartcity.capturing.eventdata;

import java.io.StringReader;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.smartcity.capturing.EPCISUnmarshaller;

public class EPCISEventUnmarshaller extends EPCISUnmarshaller {

	private EventListType eventList;

	public EPCISEventUnmarshaller() {

		eventList = new EventListType();
	}

	@SuppressWarnings("unchecked")
	public void unmarshal(String data) {

		StringReader reader = new StringReader(data);
		JAXBElement<EventListType> r = null;
		try {
			r = (JAXBElement<EventListType>) jaxbUnmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		eventList = (EventListType) r.getValue();
	}

	public EventListType getEventList() {

		return eventList;
	}

}
