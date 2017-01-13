package org.gs1.smartcity.capturing.masterdata;

import java.io.StringReader;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.gs1.epcglobal.epcis.VocabularyListType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.EPCISUnmarshaller;

public class EPCISVocabularyUnmarshaller extends EPCISUnmarshaller {
	
	private VocabularyListType vocList;
	
	public EPCISVocabularyUnmarshaller() {
		
		vocList = new VocabularyListType();
	}

	@SuppressWarnings("unchecked")
	public void unmarshal(String data) {

		StringReader reader = new StringReader(data);
		JAXBElement<VocabularyListType> r = null;
		try {
			r = (JAXBElement<VocabularyListType>) jaxbUnmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		vocList = (VocabularyListType) r.getValue();
		
	}
	
	public VocabularyType getVocabulary() {
		
		return vocList.getVocabularies().get(0);
	}
}
