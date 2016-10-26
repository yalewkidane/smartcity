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
import org.gs1.epcglobal.epcis.EPCISHeaderExtensionType;
import org.gs1.epcglobal.epcis.EPCISHeaderType;
import org.gs1.epcglobal.epcis.EPCISMasterDataType;
import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.ObjectFactory;
import org.gs1.epcglobal.epcis.VocabularyListType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.StandardBusinessDocumentHeader;
import org.xml.sax.SAXException;

public class EPCISVocabularyMarshaller {

	private ObjectFactory of;
	private EPCISDocument epcisDoc;
	private EPCISHeaderType epcisHeader;
	private EPCISHeaderExtensionType headerExtension;
	private EPCISMasterDataType masterdata;
	private VocabularyListType vocList;
	private EPCISBodyType epcisBody;
	private EventListType eventList;

	public EPCISVocabularyMarshaller() {
		of = new ObjectFactory();
		epcisDoc = of.createEPCISDocument();
		epcisHeader = of.createEPCISHeaderType();
		headerExtension = of.createEPCISHeaderExtensionType();
		masterdata = of.createEPCISMasterDataType();
		vocList = of.createVocabularyListType();
		epcisBody = of.createEPCISBodyType();
		eventList = of.createEventListType();
		
		masterdata.setVocabularyList(vocList);
		headerExtension.setEPCISMasterData(masterdata);
		epcisHeader.setExtension(headerExtension);
		epcisDoc.setEPCISHeader(epcisHeader);
		
		epcisBody.setEventList(eventList);
		epcisDoc.setEPCISBody(epcisBody);
		
		epcisDoc.getOtherAttributes().put(new QName("", "creationDate"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
		epcisDoc.getOtherAttributes().put(new QName("", "schemaVersion"), "1.2");
	}

	public void make(StandardBusinessDocumentHeader sbdh, VocabularyType voc) {
		
		epcisHeader.setStandardBusinessDocumentHeader(sbdh);
		vocList.getVocabularies().add(voc);
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
		} catch (JAXBException e1) {
			e1.printStackTrace();
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
