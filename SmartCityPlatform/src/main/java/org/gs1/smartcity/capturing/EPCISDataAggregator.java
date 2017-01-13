package org.gs1.smartcity.capturing;

import java.io.IOException;
import java.util.Properties;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.eventdata.EPCISEventUnmarshaller;
import org.gs1.smartcity.capturing.masterdata.EPCISVocabularyUnmarshaller;
import org.gs1.smartcity.util.QueryProcessor;

public class EPCISDataAggregator {

	protected static final String PROPERTY_PATH = "smartcity.properties";

	protected static String epcis_ip;
	protected static String epcis_port;
	
	protected QueryProcessor queryProcessor;

	public EPCISDataAggregator() {

		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream(PROPERTY_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}

		epcis_ip = prop.getProperty("epcis_ip");
		epcis_port = prop.getProperty("epcis_port");
		
		queryProcessor = new QueryProcessor();
	}

	public VocabularyType getVocabulary(String attributeName, String attributeValue) {

		String url = "http://" + epcis_ip + ":" + epcis_port + "/epcis/Service/Poll/SimpleMasterDataQuery?includeAttributes=true&includeChildren=true&EQATTR_" + attributeName + "=" + attributeValue;
		
		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(data.contains("<Vocabulary type")) {
			data = data.substring(data.lastIndexOf("<VocabularyList>"), data.lastIndexOf("</VocabularyList>") + "</VocabularyList>".length());
		} else {
			return null;
		}
		
		EPCISVocabularyUnmarshaller unmarshaller = new EPCISVocabularyUnmarshaller();
		unmarshaller.unmarshal(data);

		VocabularyType voc = unmarshaller.getVocabulary();

		return voc;
	}
	
	public VocabularyType getVocabulary(String query) {
		
		String url = "http://" + epcis_ip + ":" + epcis_port + "/epcis/Service/Poll/SimpleMasterDataQuery?includeAttributes=true&includeChildren=true&";
		String data = null;
		try {
			data = queryProcessor.query(url + query);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(data.contains("<Vocabulary type")) {
			data = data.substring(data.lastIndexOf("<VocabularyList>"), data.lastIndexOf("</VocabularyList>") + "</VocabularyList>".length());
		} else {
			return null;
		}
		
		EPCISVocabularyUnmarshaller unmarshaller = new EPCISVocabularyUnmarshaller();
		unmarshaller.unmarshal(data);

		VocabularyType voc = unmarshaller.getVocabulary();

		return voc;
	}

	public EventListType getEvent(String extensionType, String extensionValue) {

		String url = "http://" + epcis_ip + ":" + epcis_port + "/epcis/Service/Poll/SimpleEventQuery?EQ_" + extensionType + "=" + extensionValue;

		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(data.contains("<ObjectEvent>")) {
			data = data.substring(data.lastIndexOf("<EventList>"), data.lastIndexOf("</EventList>") + "</EventList>".length());
		} else {
			return null;
		}

		EPCISEventUnmarshaller unmarshaller = new EPCISEventUnmarshaller();
		unmarshaller.unmarshal(data);

		EventListType eventList = unmarshaller.getEventList();

		return eventList;
	}
	
	public EventListType getEvent(String query){
		
		String url = "http://" + epcis_ip + ":" + epcis_port + "/epcis/Service/Poll/SimpleEventQuery?";
		String data = null;
		try {
			data = queryProcessor.query(url + query);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		if(data.contains("<ObjectEvent>")) {
			data = data.substring(data.lastIndexOf("<EventList>"), data.lastIndexOf("</EventList>") + "</EventList>".length());
		} else {
			return null;
		}
		System.out.println("data : " + data);

		EPCISEventUnmarshaller unmarshaller = new EPCISEventUnmarshaller();
		unmarshaller.unmarshal(data);

		EventListType eventList = unmarshaller.getEventList();


		return eventList;
	}
}
