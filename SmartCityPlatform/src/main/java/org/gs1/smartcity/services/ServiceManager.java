package org.gs1.smartcity.services;

import java.util.List;

import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;

public class ServiceManager {

	private static final String GSRN = "gsrn";
	private static final String CLASS_URL = "http://smartcity.com"; 

	private DataAccessObject dataAccessObject;
	private ONSManager onsManager;
	private ServiceListMarshaller marshaller;

	public ServiceManager() {

		dataAccessObject = (new DAOFactory()).getDAO(DAOFactory.SERVICE);
		onsManager = new ONSManager();
		marshaller = new ServiceListMarshaller();
	}

	public String getServiceList(String id) {

		String serviceID = dataAccessObject.queryKey(id);

		List<String> serviceList = onsManager.query(GSRN, serviceID, CLASS_URL);

		marshaller.make(serviceList);
		String result = marshaller.marshal();
		
		return result;
	}

	public void registerService(String serviceID, String serviceUrl) {

		onsManager.register(GSRN, serviceID, CLASS_URL, serviceUrl);

	}

}
