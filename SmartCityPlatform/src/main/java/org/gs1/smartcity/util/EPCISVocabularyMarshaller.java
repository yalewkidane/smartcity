package org.gs1.smartcity.util;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.gs1.epcglobal.epcis.EPCISDocument;
import org.gs1.epcglobal.epcis.EPCISHeaderExtensionType;
import org.gs1.epcglobal.epcis.EPCISHeaderType;
import org.gs1.epcglobal.epcis.EPCISMasterDataType;
import org.gs1.epcglobal.epcis.ObjectFactory;
import org.gs1.epcglobal.epcis.VocabularyListType;

public class EPCISVocabularyMarshaller {

	private ObjectFactory of;
	private EPCISDocument epcisDoc;
	private EPCISHeaderType epcisHeader;
	private EPCISHeaderExtensionType headerExtension;
	private EPCISMasterDataType masterdata;

	public EPCISVocabularyMarshaller() {
		of = new ObjectFactory();
		epcisDoc = of.createEPCISDocument();
		epcisHeader = of.createEPCISHeaderType();
		headerExtension = of.createEPCISHeaderExtensionType();
		masterdata = of.createEPCISMasterDataType();
		headerExtension.setEPCISMasterData(masterdata);
		epcisHeader.setExtension(headerExtension);
		epcisDoc.setEPCISHeader(epcisHeader);
	}

	public void make(VocabularyListType vocList) {
		
		masterdata.setVocabularyList(vocList);
	}

	public String marshal() throws JAXBException, UnsupportedEncodingException {

		JAXBElement<EPCISDocument> e = of.createEPCISDocument(epcisDoc);
		JAXBContext jc = JAXBContext.newInstance(EPCISDocument.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Writer writer = new StringWriter();
		m.marshal(e, writer);
		String s = writer.toString();

		return s;
	}
	
}
