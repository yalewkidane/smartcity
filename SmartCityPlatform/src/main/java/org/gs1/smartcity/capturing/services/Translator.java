package org.gs1.smartcity.capturing.services;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.smartcity.capturing.EPCISDataAggregator;
import org.w3c.dom.Document;

public abstract class Translator {
	
	protected DocumentBuilderFactory factory;
	protected DocumentBuilder builder;
	protected Document document;
	protected EPCISDataAggregator aggregator;
	
	public Translator() {
		
		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		aggregator = new EPCISDataAggregator();
	}
	
	public abstract Object translate(String serviceType, String infoType, String data);

}
