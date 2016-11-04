package org.gs1.smartcity.services;

import java.util.List;

import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;

public class ServiceManager {

	private static final String GSRN = "gsrn";
	private static final String CLASS_URL = "http://smartcity.com"; 

	private DAOFactory daoFactory;
	private DataAccessObject daoS;
	private DataAccessObject daoC;
	private ONSManager onsManager;
	private ServiceListMarshaller marshaller;

	public ServiceManager() {

		daoS = daoFactory.getDAO(DAOFactory.SERVICE);
		daoC = daoFactory.getDAO(DAOFactory.SERVICE_CLASS);
		onsManager = new ONSManager();
		marshaller = new ServiceListMarshaller();
	}

	public String getServiceList(String id) {

		String serviceID = daoS.queryKey(id);

		List<String> serviceList = onsManager.query(GSRN, serviceID, CLASS_URL);

		marshaller.make(serviceList);
		String result = marshaller.marshal();
		
		return result;
	}

	public boolean registerService(String serviceID, String serviceUrl) {

		boolean reg = onsManager.register(GSRN, serviceID, CLASS_URL, serviceUrl);
		
		if(reg == false) {
			return false;
		}
		
		daoC.register(serviceUrl, serviceID);
		
		return true;
	}

}
