package org.gs1.smartcity.capturing;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ObjectFactory;

public class EPCISEventUnmarshaller {

	private EventListType eventList;

	public EPCISEventUnmarshaller() {

		eventList = new EventListType();
	}

	@SuppressWarnings("unchecked")
	public void unmarshal(String data) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(data);
		JAXBElement<EventListType> r = (JAXBElement<EventListType>) jaxbUnmarshaller.unmarshal(reader);

		eventList = (EventListType) r.getValue();
	}

	public ObjectEventType getObjectEvent() {

		return (ObjectEventType) eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().get(0);
	}

}
