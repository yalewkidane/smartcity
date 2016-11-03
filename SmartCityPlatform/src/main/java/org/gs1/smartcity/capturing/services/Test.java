package org.gs1.smartcity.capturing.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.gs1.smartcity.capturing.ServiceFactory;
import org.gs1.smartcity.capturing.masterdata.bus.BusMasterDataManager;
import org.gs1.smartcity.capturing.services.bus.BusServiceFactory;
import org.gs1.smartcity.capturing.services.bus.BusServiceManager;
import org.gs1.smartcity.datatype.bus.BusCompanyInfoType;
import org.gs1.smartcity.datatype.bus.BusVehicleInfoType;
import org.gs1.smartcity.datatype.bus.CompanyPrefixType;
import org.gs1.smartcity.datatype.bus.GIAIType;
import org.gs1.smartcity.datatype.bus.GLNType;
import org.gs1.smartcity.datatype.bus.GSRNType;
import org.gs1.smartcity.db.mongo.CompanyPrefixDAO;
import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.gs1.smartcity.db.mongo.GiaiDAO;
import org.gs1.smartcity.db.mongo.GlnDAO;
import org.gs1.smartcity.db.mongo.GsrnDAO;
import org.gs1.smartcity.etc.Identification;
import org.gs1.smartcity.etc.VehicleDAO;
import org.gs1.smartcity.util.QueryProcessor;

public class Test {

	public static void main(String[] args) {

		//		DAOFactory factory = new DAOFactory();
		//		DataAccessObject dao = factory.getDAO(DAOFactory.COMPANY_PREFIX);
		//		
		//		dao.register("ÇÐ¼º", "8803033");

		

//		GsrnDAO dao = new GsrnDAO();
//		List<GSRNType> list = dao.queryAll();
//		List<String> stopList = new ArrayList<String>();
//		for(int i = 0; i < list.size(); i ++) {
//			GSRNType gsrn = list.get(i);
//
//			if(gsrn.getObjectID().length() == 10) {
//
//				List<String> params = new ArrayList<String>();
//				params.add(gsrn.getObjectID());
//
//				UrlGenerator urlGenerator = (new UrlGeneratorFactory()).getUrlGenerator(ServiceFactory.BUS);
//				String url = urlGenerator.generate(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_ROUTE, params);
//
//				QueryProcessor queryProcessor = new QueryProcessor();
//				String data = null;
//				try {
//					data = queryProcessor.query(url);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//
//				Identification id = new Identification();
//				stopList.addAll(id.getStops(data));
//
//			}
//		}
//
//		System.out.println(stopList.get(stopList.indexOf("05244")));
//		
//		for(int i = stopList.indexOf("05244"); i < stopList.size(); i++) {
//			List<String> params = new ArrayList<String>();
//			params.add(stopList.get(i));
//			ExistingServiceManager m = (new ExistingServiceManagerFactory()).getManager(ServiceFactory.BUS);
//			String s = m.queryExistingServiceData(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_STOP_INFO, params);
//			m.registerMasterData(s);
//		}
		
		
		
		
		//		String s = m.queryExistingServiceData(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_STOP_INFO_ALL, params);
		//		m.registerMasterData(s);
		//String s = m.queryExistingServiceEvent(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_ROUTE, params);
		//m.registerEventData(s);


		//UrlGenerator urlGenerator = (new UrlGeneratorFactory()).getUrlGenerator(ServiceFactory.BUS);

		//		for(int i = 1; i <= 93; i++) {
		//			List<String> params = new ArrayList<String>();
		//			params.add(Integer.toString(i));
		//			String url = urlGenerator.generate(ServiceFactory.DAEJEON_BUS, BusServiceFactory.BUS_COMPANY_INFO, params);
		//			
		//			QueryProcessor queryProcessor = new QueryProcessor();
		//			String data = null;
		//			try {
		//				data = queryProcessor.query(url);
		//			} catch (IOException e) {
		//				e.printStackTrace();
		//			}

		//			Identification id = new Identification();
		//			id.identifyCompany();
		//}


		//insert bus route master data
		GsrnDAO gsrnDao = new GsrnDAO();
//		List<GSRNType> gsrnList = gsrnDao.queryAll();
////		for(int i = 0; i < 10; i++) {
////			
////			List<String> params = new ArrayList<String>();
////			params.add(list.get(i).getObjectID());
////			ExistingServiceManager m = (new ExistingServiceManagerFactory()).getManager(ServiceFactory.BUS);
////			String s = m.queryExistingServiceData(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_INFO, params);
////			m.registerMasterData(s);
////		}
//
//		for(int i = 0; i < list.size(); i ++) {
//			GSRNType gsrn = list.get(i);
//			List<String> params = new ArrayList<String>();
//			params.add(gsrn.getObjectID());
//			ExistingServiceManager m = (new ExistingServiceManagerFactory()).getManager(ServiceFactory.BUS);
//			String s = m.queryExistingServiceData(ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_LINE_ROUTE, params);
//			m.registerMasterData(s);
//		}
		
		//insert vehicle master data
//		VehicleDAO vehicleDao = new VehicleDAO();
//		GiaiDAO giaiDao = new GiaiDAO();
//		List<GIAIType> giaiList = giaiDao.queryAll();
//		
//		List<BusVehicleInfoType> infoList = new ArrayList<BusVehicleInfoType>();
//		
//		for(GIAIType giai : giaiList) {
//			if(giai.getObjectID().length() > 7) continue;
//			String gsrn = gsrnDao.queryKey(vehicleDao.queryKey(giai.getObjectID()));
//			gsrn = "urn:epc:id:gsrn:" + gsrn.substring(0, 8) + "." + gsrn.substring(8);
//			
//			BusVehicleInfoType info = new BusVehicleInfoType();
//			info.setGiai(giai.getGiai());
//			info.setNumber(giai.getObjectID());
//			info.setBusLine(gsrn);
//			infoList.add(info);
//			
//			BusMasterDataManager m = new BusMasterDataManager();
//			String s = m.modeling(BusServiceFactory.BUS_VEHICLE_INFO, infoList);
//			
//			BusServiceManager sm = new BusServiceManager();
//			sm.registerMasterData(s);
//		}
		
//		GlnDAO glnDao = new GlnDAO();
//		
//		List<GLNType> glnList = glnDao.queryAll();
//		List<BusCompanyInfoType> infoList = new ArrayList<BusCompanyInfoType>();
//		for(GLNType gln : glnList) {
//			
//			if(gln.getObjectID().length() == 2) {
//				
//				BusCompanyInfoType info = new BusCompanyInfoType();
//				info.setCompanyID(gln.getObjectID());
//				info.setName(gln.getObjectID());
//				info.setGln(gln.getGln());
//				
//				infoList.add(info);
//				System.out.println(info.getCompanyID() + " : " + info.getGln());
//			}
//		}
//		
//		BusMasterDataManager m = new BusMasterDataManager();
//		String s = m.modeling(BusServiceFactory.BUS_COMPANY_INFO, infoList);
//		System.out.println(s);
//		BusServiceManager sm = new BusServiceManager();
//		sm.registerMasterData(s);
		
		
		List<String> params = new ArrayList<String>();
		params.add("5200100000");
		EventCapturer ec = new EventCapturer(ServiceFactory.BUS, ServiceFactory.BUSAN_BUS, BusServiceFactory.BUS_RT_POS_INFO, params);
		
		Timer timer = new Timer();
		timer.schedule(ec, 0, 60000);
		
	}

}