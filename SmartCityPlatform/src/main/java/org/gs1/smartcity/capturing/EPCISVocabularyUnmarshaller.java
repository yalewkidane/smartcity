package org.gs1.smartcity.capturing;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.gs1.epcglobal.epcis.ObjectFactory;
import org.gs1.epcglobal.epcis.VocabularyListType;
import org.gs1.epcglobal.epcis.VocabularyType;

public class EPCISVocabularyUnmarshaller {
	
	private VocabularyListType vocList;
	
	public EPCISVocabularyUnmarshaller() {
		
		vocList = new VocabularyListType();
	}

	@SuppressWarnings("unchecked")
	public void unmarshal(String data) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(data);
		JAXBElement<VocabularyListType> r = (JAXBElement<VocabularyListType>) jaxbUnmarshaller.unmarshal(reader);

		vocList = (VocabularyListType) r.getValue();
		
	}
	
	public VocabularyType getVocabulary() {
		
		return vocList.getVocabularies().get(0);
	}
}
