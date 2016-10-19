package org.gs1.smartcity.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.gs1.epcglobal.epcis.EPCISDocument;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ObjectFactory;
import org.gs1.epcglobal.epcis.VocabularyType;

public class EPCISUnmarshaller {
	
	private EPCISDocument doc;
	
	public EPCISUnmarshaller() {
		
		doc = new EPCISDocument();
	}

	@SuppressWarnings("unchecked")
	public void unmarshal(String data) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(data);
		JAXBElement<EPCISDocument> r = (JAXBElement<EPCISDocument>) jaxbUnmarshaller.unmarshal(reader);

		doc = (EPCISDocument) r.getValue();
		
	}
	
	public VocabularyType getVocabulary() {
		
		return doc.getEPCISHeader().getExtension().getEPCISMasterData().getVocabularyList().getVocabularies().get(0);
	}
	
	public ObjectEventType getObjectEvent() {
		
		return (ObjectEventType) doc.getEPCISBody().getEventList().getObjectEventsAndAggregationEventsAndQuantityEvents().get(0);
	}
}
