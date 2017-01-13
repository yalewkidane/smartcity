package org.gs1.smartcity.capturing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.gs1.epcglobal.epcis.ObjectFactory;

public abstract class EPCISUnmarshaller {
	
	protected JAXBContext jaxbContext;
	protected Unmarshaller jaxbUnmarshaller;
	
	public EPCISUnmarshaller() {
		
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		try {
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void unmarshal(String data);

}
