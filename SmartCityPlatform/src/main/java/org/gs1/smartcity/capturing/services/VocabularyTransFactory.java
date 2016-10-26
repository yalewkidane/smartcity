package org.gs1.smartcity.capturing.services;

import org.gs1.smartcity.capturing.services.bus.BusVocabularyTranslator;

public class VocabularyTransFactory {

	public VocabularyTranslator getTrans(String type) {

		VocabularyTranslator trans = null;

		if(type.equals(ServiceFactory.BUS)) {

			trans = new BusVocabularyTranslator();
		}

		return trans;

	}

}