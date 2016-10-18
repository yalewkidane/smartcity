package org.gs1.smartcity.capturing.services;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.epcglobal.epcis.VocabularyListType;
import org.gs1.smartcity.capturing.services.bus.BusServiceFactory;
import org.gs1.smartcity.capturing.services.bus.BusUrlGenerator;
import org.gs1.smartcity.util.EPCISVocabularyMarshaller;

public class ExistingServiceManager {

	public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException {
		// TODO Auto-generated method stub
		
		QueryProcessor queryProcessor = new QueryProcessor();
		
		TransFactory transFactory = new TransFactory();
		VocabularyTranslator trans = transFactory.getTrans(ServiceFactory.BUS);
		
		UrlGenerator urlGenerator = new BusUrlGenerator(ServiceFactory.DAEJEON_BUS);
		
		String url = urlGenerator.generate(BusServiceFactory.DAEJEON_BUS_LINE_INFO_ALL, "2", null);
		String data = queryProcessor.query(url);
		System.out.println(url);
		VocabularyListType vocList = trans.translate(BusServiceFactory.DAEJEON_BUS_LINE_INFO_ALL, data);
		
		EPCISVocabularyMarshaller vm = new EPCISVocabularyMarshaller();
		vm.make(vocList);
		
		String s = vm.marshal();
		System.out.println(s);
		
		//register master data - bus line, bus stop
		
		
		
		
		//register event data periodically - bus arrival, line-stop, bus location
		
		
		
		

	}

}
