package org.gs1.smartcity.capturing.metadata;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.gs1.source.tsd.ObjectFactory;
import org.gs1.source.tsd.TSDProductDataType;

public class MetadataUnmarshaller {
	
	private TSDProductDataType productData;
	
	protected JAXBContext jaxbContext;
	protected Unmarshaller jaxbUnmarshaller;
	
	public MetadataUnmarshaller() {
		
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
	
	@SuppressWarnings("unchecked")
	public void unmarshal(String data) {
		
		StringReader reader = new StringReader(data);
		JAXBElement<TSDProductDataType> r = null;
		try {
			r = (JAXBElement<TSDProductDataType>) jaxbUnmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		productData = (TSDProductDataType) r.getValue();
	}
	
	public TSDProductDataType getProductData() {
		
		return productData;
	}

}
