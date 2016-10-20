package org.gs1.smartcity.capturing.services;

import javax.xml.parsers.ParserConfigurationException;

import org.gs1.smartcity.capturing.services.bus.BusVocabularyTranslator;

public class VocabularyTransFactory {
	
	public VocabularyTranslator getTrans(String type) {
		
		VocabularyTranslator trans = null;
		
		if(type.equals(ServiceFactory.BUS)) {
			
			try {
				trans = new BusVocabularyTranslator();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}
		
		return trans;
		
	}

}