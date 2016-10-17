package org.gs1.smartcity.capturing.services;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.services.bus.BusInfoFactory;
import org.gs1.smartcity.util.EPCISVocabularyMarshaller;

public class ExistingServiceManager {

	public static void main(String[] args) throws IOException, JAXBException {
		// TODO Auto-generated method stub
		
		QueryProcessor queryProcessor = new QueryProcessor();
		
		TransFactory transFactory = new TransFactory();
		Translator trans = transFactory.getTrans(ServiceFactory.BUSAN_BUS);
		
		ServiceUrlFactory urlFactory = new ServiceUrlFactory();
		UrlGenerator urlGenerator = urlFactory.getUrlGenerator(ServiceFactory.BUSAN_BUS);
		
		String url = urlGenerator.generate(BusInfoFactory.BUSAN_BUS_STOP_INFO, "13045", null);
		String data = queryProcessor.query(url);
		
		VocabularyType voc = trans.masterDataTranslate(BusInfoFactory.BUSAN_BUS_STOP_INFO, data);
		
		EPCISVocabularyMarshaller vm = new EPCISVocabularyMarshaller();
		vm.make(voc);
		
		String s = vm.marshal();
		System.out.println(s);
		
		//register master data - bus line, bus stop
		
		
		
		
		//register event data periodically - bus arrival, line-stop, bus location
		
		
		
		

	}

}
