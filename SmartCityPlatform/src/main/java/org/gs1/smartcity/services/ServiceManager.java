package org.gs1.smartcity.services;

import java.util.ArrayList;
import java.util.List;

import org.gs1.smartcity.datatype.service.ServiceType;
import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;

public class ServiceManager {

	private static final String GSRN = "gsrn";
	private static final String CLASS_URL = "http://smartcity.com"; 

	private DAOFactory daoFactory;
	private DataAccessObject daoO;
	private DataAccessObject daoC;
	private DataAccessObject daoS;
	private ONSManager onsManager;
	private ServiceListMarshaller marshaller;

	public ServiceManager() {

		daoFactory = DAOFactory.getInstance();
		daoO = daoFactory.getDAO(DAOFactory.OBJECT_SERVICE);
		daoC = daoFactory.getDAO(DAOFactory.SERVICE_CLASS);
		daoS = daoFactory.getDAO(DAOFactory.SERVICE);
		onsManager = new ONSManager();
		marshaller = new ServiceListMarshaller();
	}

	public String getServiceList(String id) {

		String serviceID = daoO.queryKey(id);

		List<String> services = onsManager.query(GSRN, serviceID, CLASS_URL);
		List<ServiceType> serviceList = new ArrayList<ServiceType>();
		for(String service : services) {
			ServiceType s = new ServiceType();
			s.setServiceUrl(service);
			s.setServiceName(daoS.queryKey(service));
			serviceList.add(s);
		}

		marshaller.make(serviceList);
		String result = marshaller.marshal();

		return result;
	}

	public boolean registerServiceClass(String classID, String className) {
		
		boolean reg = onsManager.register(GSRN, classID, CLASS_URL);
		
		if(reg == false) {
			return false;
		}

		return daoC.register(classID, className);
	}

	public boolean registerService(String className, String serviceName, String serviceUrl) {
		
		String classID = daoC.queryKey(className);

		boolean reg = onsManager.registerRdata(GSRN, classID, CLASS_URL, serviceUrl);

		if(reg == false) {
			return false;
		}

		return daoS.register(serviceName, serviceUrl);
	}

}
