package org.gs1.smartcity.capturing.services.bus;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.EPCISEventMarshaller;
import org.gs1.smartcity.capturing.EPCISVocabularyMarshaller;
import org.gs1.smartcity.capturing.services.ExistingServiceManager;
import org.gs1.smartcity.capturing.services.ServiceFactory;
import org.gs1.smartcity.util.QueryProcessor;

public class BusServiceManager extends ExistingServiceManager{

	public BusServiceManager() {

		super(ServiceFactory.BUS);
	}

	public String queryExistingServiceData(String serviceType, String infoType, List<String> params) {

		String url = urlGenerator.generate(serviceType, infoType, params);

		QueryProcessor queryProcessor = new QueryProcessor();
		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Object object = vocTranslator.translate(serviceType, infoType, data);

		VocabularyType voc = masterDataManager.modelingVocabulary(infoType, object);

		EPCISVocabularyMarshaller vm = new EPCISVocabularyMarshaller();
		vm.make(voc);

		String result = null;
		try {
			result = vm.marshal();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		System.out.println(result);

		return result;

	}

	public String queryExistingServiceEvent(String serviceType, String infoType, List<String> params) {

		String url = urlGenerator.generate(serviceType, infoType, params);

		QueryProcessor queryProcessor = new QueryProcessor();
		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Object object = eventTranslator.translate(serviceType, infoType, data);

		EventListType objectEvent = eventDataManager.modelingObjectEvent(infoType, object);

		EPCISEventMarshaller em = new EPCISEventMarshaller();
		em.make(objectEvent);

		String result = null;
		try {
			result = em.marshal();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		System.out.println(result);

		return result;
	}

	public void registerMasterData(String data) {

		int result = 0;
		try {
			result = masterDataManager.registerEPCIS(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(result == 200) {
			System.out.println("data is successfully registered");
		} else {
			System.out.println("error code:" + result);
		}
	}

	public void registerEventData(String data) {

		int result = 0;
		try {
			result = eventDataManager.registerEPCIS(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(result == 200) {
			System.out.println("data is successfully registered");
		} else {
			System.out.println("error code:" + result);
		}
	}
}
