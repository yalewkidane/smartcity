package org.gs1.smartcity.capturing.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gs1.smartcity.capturing.services.bus.BusServiceFactory;
import org.gs1.smartcity.datatype.bus.GSRNType;
import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.gs1.smartcity.db.mongo.GsrnDAO;
import org.gs1.smartcity.etc.Identification;
import org.gs1.smartcity.util.QueryProcessor;

public class Test {

	public static void main(String[] args) {

//		DAOFactory factory = new DAOFactory();
//		DataAccessObject dao = factory.getDAO(DAOFactory.COMPANY_PREFIX);
//		
//		dao.register("ÇÐ¼º", "8803033");
		
//		ExistingServiceManager m = (new ExistingServiceManagerFactory()).getManager(ServiceFactory.BUS);
//		
//		List<String> params = new ArrayList<String>();
//		params.add("5200179000");
//		String s = m.queryExistingServiceData(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_ROUTE, params);
		//m.registerMasterData(s);
		//String s = m.queryExistingServiceEvent(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_ROUTE, params);
		//m.registerEventData(s);
		
		//vehicle insert
//		GsrnDAO gDAO = new GsrnDAO();
//		List<GSRNType> list = gDAO.queryAll();
//		for(int i = 0; i < list.size(); i ++) {
//			List<String> params = new ArrayList<String>();
//			params.add(list.get(i).getObjectID());
//
//
//			UrlGenerator urlGenerator = (new UrlGeneratorFactory()).getUrlGenerator(ServiceFactory.BUS);
//			String url = urlGenerator.generate(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_ROUTE, params);
//
//			QueryProcessor queryProcessor = new QueryProcessor();
//			String data = null;
//			try {
//				data = queryProcessor.query(url);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			Identification id = new Identification();
//			id.identifyVehicle(params.get(0), data);
//		}
		
		UrlGenerator urlGenerator = (new UrlGeneratorFactory()).getUrlGenerator(ServiceFactory.BUS);
		String url = urlGenerator.generate(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_STOP_INFO_ALL, null);

		QueryProcessor queryProcessor = new QueryProcessor();
		String data = null;
		try {
			data = queryProcessor.query(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Identification id = new Identification();
		id.identifyBusStop(data);
		
	}

}