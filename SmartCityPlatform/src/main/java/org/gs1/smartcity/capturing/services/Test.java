package org.gs1.smartcity.capturing.services;

import java.util.ArrayList;
import java.util.List;

import org.gs1.smartcity.capturing.services.bus.BusServiceFactory;
import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;

public class Test {

	public static void main(String[] args) {

		DAOFactory factory = new DAOFactory();
		DataAccessObject dao = factory.getDAO(DAOFactory.GLN);
//		
//		dao.register("8001378", "8802345123456");
//		
//		String s = dao.queryKey("8001378");
//		
//		System.out.println(s);
		
		ExistingServiceManager m = (new ExistingServiceManagerFactory()).getManager(ServiceFactory.BUS);
		
		List<String> params = new ArrayList<String>();
		params.add("5200179000");
		//String s = m.queryExistingServiceData(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_ROUTE, params);
		//m.registerMasterData(s);
		String s = m.queryExistingServiceEvent(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_ROUTE, params);
		
	
		
	}

}