package org.gs1.smartcity.capturing.services;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.gs1.epcglobal.EPC;
import org.gs1.epcglobal.epcis.ActionType;
import org.gs1.epcglobal.epcis.AttributeType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.BusinessTransactionListType;
import org.gs1.epcglobal.epcis.BusinessTransactionType;
import org.gs1.epcglobal.epcis.EPCISBodyType;
import org.gs1.epcglobal.epcis.EPCISDocument;
import org.gs1.epcglobal.epcis.EPCListType;
import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ObjectFactory;
import org.gs1.epcglobal.epcis.ReadPointType;
import org.gs1.epcglobal.epcis.VocabularyElementListType;
import org.gs1.epcglobal.epcis.VocabularyElementType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.datatype.bus.BusStopInfo;
import org.gs1.smartcity.util.EPCISEventMarshaller;
import org.gs1.smartcity.util.EPCISVocabularyMarshaller;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException, JAXBException {
		// TODO Auto-generated method stub

//		ObjectEventType obj = new ObjectEventType();
//		
//		EPCListType epcList = new EPCListType();
//		EPC e = new EPC();
//		e.setValue("urn:epc:id:sgtin:0614141.107346.2017");
//		epcList.getEpcs().add(e);
//		
//		obj.setEpcList(epcList);
//		
//		obj.setAction(ActionType.OBSERVE);
//		
//		obj.setBizStep("urn:epcglobal:cbv:bizstep:shipping");
//		
//		obj.setDisposition("urn:epcglobal:cbv:disp:in_transit");
//		
//		ReadPointType readpoint = new ReadPointType();
//		readpoint.setId("urn:epc:id:sgln:0614141.07346.1234");
//		obj.setReadPoint(readpoint);
//		
//		BusinessTransactionListType bizTList = new BusinessTransactionListType();
//		BusinessTransactionType bizT = new BusinessTransactionType();
//		bizT.setType("urn:epcglobal:cbv:btt:po");
//		bizT.setValue("http://transaction.acme.com/po/12345678");		
//		bizTList.getBizTransactions().add(bizT);
//		obj.setBizTransactionList(bizTList);
//		
//		EPCISEventMarshaller m = new EPCISEventMarshaller();
//		m.make(obj);
//		String s = m.marshal();
		
//		VocabularyType voc = new VocabularyType();
//		
//		voc.setType("urn:epcglobal:epcis:vtype:BusinessLocation");
//		
//		VocabularyElementListType vocElementList = new VocabularyElementListType();
//		VocabularyElementType vocElement = new VocabularyElementType();
//		vocElement.setId("urn:epc:id:sgln:0037000.00729.8202");
//		AttributeType att = new AttributeType();
//		att.setId("urn:epcglobal:cbv:mda:site");
//		att.getContent().add("0037000007296");
//		vocElement.getAttributes().add(att);
//		AttributeType att2 = new AttributeType();
//		att2.setId("urn:epcglobal:cbv:mda:sst");
//		att2.getContent().add("202");
//		vocElement.getAttributes().add(att2);
//		
//		vocElementList.getVocabularyElements().add(vocElement);
//		
//		voc.setVocabularyElementList(vocElementList);
//		
//		EPCISVocabularyMarshaller m = new EPCISVocabularyMarshaller();
//		m.make(voc);
//		String s = m.marshal();
//		
//		System.out.println(s);
//		
	
	}

}