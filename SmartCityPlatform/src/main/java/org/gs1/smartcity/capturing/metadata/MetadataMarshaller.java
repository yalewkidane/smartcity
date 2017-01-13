package org.gs1.smartcity.capturing.metadata;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.gs1.source.tsd.ObjectFactory;
import org.gs1.source.tsd.TSDProductDataType;
import org.xml.sax.SAXException;

public class MetadataMarshaller {

	protected ObjectFactory of;
	protected TSDProductDataType productData;
	protected SchemaFactory sf;
	protected Schema schema;
	protected JAXBContext jc;
	protected Marshaller m;

	public MetadataMarshaller() {

		of = new ObjectFactory();
		productData = of.createTSDProductDataType();
		sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		try {
			schema = sf.newSchema(new File("src/main/java/org/gs1/source/schema/tsd/ProductData.xsd"));
		} catch (SAXException e2) {
			e2.printStackTrace();
		}
		
		try {
			jc = JAXBContext.newInstance(TSDProductDataType.class);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		
		try {
			m = jc.createMarshaller();
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		
		try {
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch (PropertyException e1) {
			e1.printStackTrace();
		}
	}
	
	public void make(TSDProductDataType pd) {
		
		productData.setGtin(pd.getGtin());
		productData.setTargetMarket(pd.getTargetMarket());
		productData.setInformationProviderGLN(pd.getInformationProviderGLN());
		productData.setInformationProviderName(pd.getInformationProviderName());
		productData.setAvpList(pd.getAvpList());
	}

	public String marshal() {

		JAXBElement<TSDProductDataType> e = of.createProductData(productData);

		Writer writer = new StringWriter();
		try {
			m.marshal(e, writer);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}

		String s = writer.toString();

		return s;
	}

}
