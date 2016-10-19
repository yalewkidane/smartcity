package org.gs1.smartcity.capturing.services;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.EPCISVocabularyMarshaller;
import org.gs1.smartcity.capturing.masterdata.MasterDataManager;
import org.gs1.smartcity.capturing.services.bus.BusMasterDataManager;
import org.gs1.smartcity.capturing.services.bus.BusServiceFactory;
import org.gs1.smartcity.capturing.services.bus.BusUrlGenerator;
import org.gs1.smartcity.util.QueryProcessor;

public class ExistingServiceManager {

	public void queryData() throws IOException, JAXBException, ParserConfigurationException {
		
		QueryProcessor queryProcessor = new QueryProcessor();
		
		TransFactory transFactory = new TransFactory();
		VocabularyTranslator trans = transFactory.getTrans(ServiceFactory.BUS);
		
		UrlGenerator urlGenerator = new BusUrlGenerator(ServiceFactory.DAEJEON_BUS);
		
		String url = urlGenerator.generate(BusServiceFactory.DAEJEON_BUS_COMPANY_INFO, "1", null);
		String data = queryProcessor.query(url);
		System.out.println(url);
		Object obj = trans.translate(BusServiceFactory.DAEJEON_BUS_COMPANY_INFO, data);
		
		MasterDataManager mdm = new BusMasterDataManager();
		VocabularyType voc = mdm.modelingVocabulary(BusServiceFactory.BUS_COMPANY_INFO, obj);
		
		EPCISVocabularyMarshaller vm = new EPCISVocabularyMarshaller();
		vm.make(voc);
		
		String result = vm.marshal();
		System.out.println(result);
		
		mdm.registerEPCIS(result);
		
	}

}
