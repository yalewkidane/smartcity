package org.gs1.smartcity.capturing.services;

import javax.xml.parsers.ParserConfigurationException;

import org.gs1.smartcity.capturing.services.bus.BusVocabularyTranslator;

public class TransFactory {
	
	public VocabularyTranslator getTrans(String type) throws ParserConfigurationException {
		
		VocabularyTranslator trans = null;
		
		if(type.equals("bus")) {
			
			trans = new BusVocabularyTranslator();
		}
		
		return trans;
		
	}

}
