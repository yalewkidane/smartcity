package org.gs1.smartcity.capturing;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.util.EPCISUnmarshaller;
import org.gs1.smartcity.util.QueryProcessor;

public class EPCISDataAggregator {

	public VocabularyType getVocabulary(String attributeName, String attributeValue) throws IOException, JAXBException {
		
		QueryProcessor queryProcessor = new QueryProcessor();
		String url = "http://{base-url}:{base-port}/epcis/Service/Poll/SimpleMasterDataQuery?EQATTR_=" + attributeName + "&" + attributeValue;
		
		String data = queryProcessor.query(url);
		
		EPCISUnmarshaller unmarshaller = new EPCISUnmarshaller();
		unmarshaller.unmarshal(data);
			
		VocabularyType voc = unmarshaller.getVocabulary();
		
		return voc;
	}
	
	public ObjectEventType getEvent(String extensionType, String extensionValue) throws IOException, JAXBException {
		
		QueryProcessor queryProcessor = new QueryProcessor();
		String url = "http://{base-url}:{base-port}/epcis/Service/Poll/SimpleEventQuery?EQ_=" + extensionType + "&" + extensionValue;
		
		String data = queryProcessor.query(url);
		
		EPCISUnmarshaller unmarshaller = new EPCISUnmarshaller();
		unmarshaller.unmarshal(data);
		
		ObjectEventType obj = unmarshaller.getObjectEvent();
		
		return obj;
	}
}
