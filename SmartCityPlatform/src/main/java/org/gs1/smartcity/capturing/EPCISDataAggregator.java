package org.gs1.smartcity.capturing;

import java.io.IOException;
import java.util.Properties;

import javax.xml.bind.JAXBException;

import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.util.EPCISUnmarshaller;
import org.gs1.smartcity.util.QueryProcessor;

public class EPCISDataAggregator {
	
	protected static final String PROPERTY_PATH = "smartcity.properties";

	protected static String epcis_ip;
	protected static String epcis_port;
	
	public EPCISDataAggregator() {
		
		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream(PROPERTY_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		epcis_ip = prop.getProperty("epcis_ip");
		epcis_port = prop.getProperty("epcis_port");
	}

	public VocabularyType getVocabulary(String attributeName, String attributeValue) {
		
		QueryProcessor queryProcessor = new QueryProcessor();
		String url = "http://" + epcis_ip + ":" + epcis_port + "/epcis/Service/Poll/SimpleMasterDataQuery?EQATTR_=" + attributeName + "&" + attributeValue;
		
		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		EPCISUnmarshaller unmarshaller = new EPCISUnmarshaller();
		try {
			unmarshaller.unmarshal(data);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
			
		VocabularyType voc = unmarshaller.getVocabulary();
		
		return voc;
	}
	
	public ObjectEventType getEvent(String extensionType, String extensionValue) {
		
		QueryProcessor queryProcessor = new QueryProcessor();
		String url = "http://" + epcis_ip + ":" + epcis_port + "/epcis/Service/Poll/SimpleEventQuery?EQ_=" + extensionType + "&" + extensionValue;
		
		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		EPCISUnmarshaller unmarshaller = new EPCISUnmarshaller();
		try {
			unmarshaller.unmarshal(data);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		ObjectEventType obj = unmarshaller.getObjectEvent();
		
		return obj;
	}
}
