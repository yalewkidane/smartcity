package org.gs1.smartcity.capturing;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.gs1.epcglobal.epcis.EPCISBodyType;
import org.gs1.epcglobal.epcis.EPCISDocument;
import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.ObjectFactory;
import org.xml.sax.SAXException;

public class EPCISEventMarshaller {
	
	private ObjectFactory of;
	private EPCISDocument epcisDoc;
	private EPCISBodyType epcisBody;

	public EPCISEventMarshaller() {
		of = new ObjectFactory();
		epcisDoc = of.createEPCISDocument();
		epcisBody = of.createEPCISBodyType();
		
		epcisDoc.setEPCISBody(epcisBody);
		
		epcisDoc.getOtherAttributes().put(new QName("", "creationDate"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
		epcisDoc.getOtherAttributes().put(new QName("", "schemaVersion"), "1.2");
	}

	public void make(EventListType eventList) {
		
		epcisBody.setEventList(eventList);
	}

	public String marshal() {
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = null;
		try {
			schema = sf.newSchema(new File("src/main/java/org/gs1/epcglobal/epcis/schema/EPCglobal-epcis-1_2.xsd"));
		} catch (SAXException e2) {
			e2.printStackTrace();
		}

		JAXBElement<EPCISDocument> e = of.createEPCISDocument(epcisDoc);
		JAXBContext jc = null;
		try {
			jc = JAXBContext.newInstance(EPCISDocument.class);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		
		Marshaller m = null;
		try {
			m = jc.createMarshaller();
		} catch (JAXBException e2) {
			e2.printStackTrace();
		}
		
		try {
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch (PropertyException e1) {
			e1.printStackTrace();
		}
		m.setSchema(schema);
		
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
