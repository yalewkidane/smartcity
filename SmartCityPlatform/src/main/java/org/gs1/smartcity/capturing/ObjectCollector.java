package org.gs1.smartcity.capturing;

import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;

public class ObjectCollector {
	
	protected DAOFactory daoFactory;
	protected DataAccessObject daoD;
	protected DataAccessObject daoC;
	protected DataAccessObject daoS;
	
	public ObjectCollector() {
		
		daoFactory = new DAOFactory();
		daoC = daoFactory.getDAO(DAOFactory.SERVICE_CLASS);
		daoS = daoFactory.getDAO(DAOFactory.SERVICE);
	}
	
	public void collect(String objectID, String targetID, String serviceUrl, String type) {
		
		daoD = daoFactory.getDAO(type);
		daoD.register(objectID, targetID);
		if(serviceUrl != null) {
			couplingService(targetID, serviceUrl);
		}
		
	}
	
	protected void couplingService(String targetID, String serviceUrl) {
		
		String serviceID = daoC.queryKey(serviceUrl);
		daoS.register(targetID, serviceID);
		
	}
}
