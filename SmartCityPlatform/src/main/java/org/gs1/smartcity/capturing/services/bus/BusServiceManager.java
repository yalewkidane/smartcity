package org.gs1.smartcity.capturing.services.bus;

import java.io.IOException;
import java.util.List;

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

		if(infoType.equals(BusServiceFactory.BUS_LINE_ROUTE)) {
			data = params.get(0) + data;
		}
		Object object = vocTranslator.translate(serviceType, infoType, data);

		String result = masterDataManager.modeling(infoType, object);

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

		String result = eventDataManager.modeling(infoType, object);

		System.out.println(result);

		return result;
	}

	public void registerMasterData(String data) {

		int result = masterDataManager.registerEPCIS(data);

		if(result == 200) {
			System.out.println("data is successfully registered");
		} else {
			System.out.println("error code:" + result);
		}
	}

	public void registerEventData(String data) {

		int result = eventDataManager.registerEPCIS(data);

		if(result == 200) {
			System.out.println("data is successfully registered");
		} else {
			System.out.println("error code:" + result);
		}
	}
}
