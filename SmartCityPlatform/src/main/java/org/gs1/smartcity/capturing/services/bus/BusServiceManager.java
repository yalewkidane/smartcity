package org.gs1.smartcity.capturing.services.bus;

import java.io.IOException;
import java.util.List;

import org.gs1.smartcity.capturing.ServiceFactory;
import org.gs1.smartcity.capturing.services.ExistingServiceManager;
import org.gs1.smartcity.util.QueryProcessor;

public class BusServiceManager extends ExistingServiceManager{

	public BusServiceManager() {

		super(ServiceFactory.BUS);
	}

	public String queryExistingServiceData(String serviceName, String serviceType, List<String> params) {

		String url = urlGenerator.generate(serviceName, serviceType, params);
		System.out.println(url);

		QueryProcessor queryProcessor = new QueryProcessor();
		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(data);

		if(serviceType.equals(BusServiceFactory.BUS_LINE_ROUTE)) {
			data = params.get(0) + data;
		}
		Object object = vocTranslator.translate(serviceName, serviceType, data);

		String result = masterDataManager.modeling(serviceType, object);

		System.out.println(result);

		return result;

	}

	public String queryExistingServiceEvent(String serviceName, String serviceType, List<String> params) {

		String url = urlGenerator.generate(serviceName, serviceType, params);

		QueryProcessor queryProcessor = new QueryProcessor();
		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("data : " + data);

		Object object = eventTranslator.translate(serviceName, serviceType, data);

		String result = eventDataManager.modeling(serviceType, object);

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
