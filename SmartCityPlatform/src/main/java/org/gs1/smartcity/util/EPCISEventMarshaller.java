package org.gs1.smartcity.util;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.gs1.epcglobal.epcis.EPCISBodyType;
import org.gs1.epcglobal.epcis.EPCISDocument;
import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ObjectFactory;

public class EPCISEventMarshaller {
	
	private ObjectFactory of;
	private EPCISDocument epcisDoc;
	private EPCISBodyType epcisBody;
	private EventListType eventList;

	public EPCISEventMarshaller() {
		of = new ObjectFactory();
		epcisDoc = of.createEPCISDocument();
		epcisBody = of.createEPCISBodyType();
		eventList = of.createEventListType();
		epcisBody.setEventList(eventList);
		epcisDoc.setEPCISBody(epcisBody);
	}

	public void make(ObjectEventType objectEvent) {
		
		eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(objectEvent);
	}

	public String marshal() throws JAXBException, UnsupportedEncodingException {

		JAXBElement<EPCISDocument> e = of.createEPCISDocument(epcisDoc);
		JAXBContext jc = JAXBContext.newInstance(EPCISDocument.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Writer writer = new StringWriter();
		m.marshal(e, writer);
		String s = writer.toString();

		return s;
	}

}
