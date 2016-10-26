package org.gs1.smartcity.capturing.services.bus;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.gs1.smartcity.capturing.services.ServiceFactory;
import org.gs1.smartcity.capturing.services.VocabularyTranslator;
import org.gs1.smartcity.datatype.bus.BusCompanyInfoType;
import org.gs1.smartcity.datatype.bus.BusIntervalType;
import org.gs1.smartcity.datatype.bus.BusLineInfoType;
import org.gs1.smartcity.datatype.bus.BusLineRouteType;
import org.gs1.smartcity.datatype.bus.BusRouteStopInfoType;
import org.gs1.smartcity.datatype.bus.BusStopInfoType;
import org.gs1.smartcity.datatype.bus.BusTimeType;
import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class BusVocabularyTranslator extends VocabularyTranslator {

	public Object translate(String serviceType, String infoType, String data)  {

		if(serviceType.equals(ServiceFactory.BUSAN_BUS)) {
			if (infoType.equals(BusServiceFactory.BUS_LINE_INFO) || infoType.equals(BusServiceFactory.BUS_LINE_INFO_ALL)) {
				return translateBusanBusLineInfo(data);
			} else if (infoType.equals(BusServiceFactory.BUS_STOP_INFO)) {
				return translateBusanBusStopInfo(data);
			} else if (infoType.equals(BusServiceFactory.BUS_LINE_ROUTE)) {
				return translateBusanBusLineRouteInfo(data);
			} else if (infoType.equals(BusServiceFactory.BUS_STOP_ARR)) {

			} else if (infoType.equals(BusServiceFactory.BUS_LINE_STOP_ARR)) {

			}
		} else if (serviceType.equals(ServiceFactory.DAEJEON_BUS)) {
			if (infoType.equals(BusServiceFactory.BUS_LINE_INFO) || infoType.equals(BusServiceFactory.BUS_LINE_INFO_ALL)) {
				return translateDaejeonBusLineInfo(data);
			} else if (infoType.equals(BusServiceFactory.BUS_STOP_INFO)) {
				return translateDaejeonBusStopInfo(data);
			} else if (infoType.equals(BusServiceFactory.BUS_LINE_ROUTE)) {
				return translateDaejeonBusLineRouteInfo(data);
			} else if (infoType.equals(BusServiceFactory.BUS_COMPANY_INFO)) {
				return translateDaejeonBusCompanyInfo(data);
			}
		}

		return null;
	}

	private List<BusLineInfoType> translateBusanBusLineInfo(String data) {

		List<BusLineInfoType> infoList = new ArrayList<BusLineInfoType>();

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusLineInfoType info = new BusLineInfoType();

			DAOFactory factory = new DAOFactory();
			DataAccessObject dao = factory.getDAO(DAOFactory.GSRN);
			info.setGsrn(dao.queryKey(element.getElementsByTagName("lineId").item(0).getFirstChild().getNodeValue()));

			//info.setGsrn("8801234123456");

			info.setLineID(element.getElementsByTagName("lineId").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("buslinenum").item(0).getFirstChild().getNodeValue());
			info.setBusType(element.getElementsByTagName("bustype").item(0).getFirstChild().getNodeValue());
			info.setCompany(element.getElementsByTagName("companyid").item(0).getFirstChild().getNodeValue());

			BusStopInfoType startPoint = new BusStopInfoType();
			BusStopInfoType endPoint = new BusStopInfoType();
			startPoint.setNameKR(element.getElementsByTagName("startpoint").item(0).getFirstChild().getNodeValue());
			endPoint.setNameKR(element.getElementsByTagName("endpoint").item(0).getFirstChild().getNodeValue());
			info.setStartPoint(startPoint);
			info.setEndPoint(endPoint);

			BusTimeType startTime = new BusTimeType();
			BusTimeType endTime = new BusTimeType();
			startTime.setTime(element.getElementsByTagName("firsttime").item(0).getFirstChild().getNodeValue());
			endTime.setTime(element.getElementsByTagName("endtime").item(0).getFirstChild().getNodeValue());
			info.setStartTime(startTime);
			info.setEndTime(endTime);

			if(element.getElementsByTagName("headway").item(0) != null) {
				BusIntervalType interval = new BusIntervalType();
				interval.setInterval(element.getElementsByTagName("headway").item(0).getFirstChild().getNodeValue());
				if(element.getElementsByTagName("headwayNorm") != null) {
					interval.setIntervalNorm(element.getElementsByTagName("headwayNorm").item(0).getFirstChild().getNodeValue());
				}
				if(element.getElementsByTagName("headwayPeak") != null) {
					interval.setIntervalPeak(element.getElementsByTagName("headwayPeak").item(0).getFirstChild().getNodeValue());
				}
				info.setInterval(interval);
			}

			infoList.add(info);
		}

		return infoList;
	}

	private List<BusStopInfoType> translateBusanBusStopInfo(String data) {

		List<BusStopInfoType> infoList = new ArrayList<BusStopInfoType>();

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusStopInfoType info = new BusStopInfoType();

			DAOFactory factory = new DAOFactory();
			DataAccessObject dao = factory.getDAO(DAOFactory.GLN);
			info.setGln(dao.queryKey(element.getElementsByTagName("bstopId").item(0).getFirstChild().getNodeValue()));

			//info.setGln("8801234123456");

			info.setStopID(element.getElementsByTagName("bstopId").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("bstopArsno").item(0).getFirstChild().getNodeValue());
			info.setNameKR(element.getElementsByTagName("bstopNm").item(0).getFirstChild().getNodeValue());
			info.setGpsX(element.getElementsByTagName("gpsX").item(0).getFirstChild().getNodeValue());
			info.setGpsY(element.getElementsByTagName("gpsY").item(0).getFirstChild().getNodeValue());

			infoList.add(info);
		}

		return infoList;
	}

	private BusLineRouteType translateBusanBusLineRouteInfo(String data) {

		String dataBody = data.substring(data.lastIndexOf("<?xml"));
		String key = data.substring(0, data.lastIndexOf("<?xml"));

		try {
			document = builder.parse(new InputSource(new StringReader(dataBody)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("item");

		BusLineRouteType info = new BusLineRouteType();

		DAOFactory factory = new DAOFactory();
		DataAccessObject dao = factory.getDAO(DAOFactory.GSRN);
		info.setGsrn(dao.queryKey(key));

		//info.setGsrn("8801234123456");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusRouteStopInfoType bsinfo = new BusRouteStopInfoType();
			bsinfo.setIndex(i+1);
			bsinfo.setStopID(element.getElementsByTagName("nodeId").item(0).getFirstChild().getNodeValue());
			bsinfo.setNumber(element.getElementsByTagName("arsNo").item(0).getFirstChild().getNodeValue());
			bsinfo.setNameKR(element.getElementsByTagName("bstopnm").item(0).getFirstChild().getNodeValue());

			info.getStopList().add(bsinfo);
		}

		return info;
	}

	private List<BusLineInfoType> translateDaejeonBusLineInfo(String data) {

		List<BusLineInfoType> infoList = new ArrayList<BusLineInfoType>();

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("itemList");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusLineInfoType info = new BusLineInfoType();

			DAOFactory factory = new DAOFactory();
			DataAccessObject dao = factory.getDAO(DAOFactory.GSRN);
			info.setGsrn(dao.queryKey(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue()));

			//info.setGsrn("8801234123456");

			info.setLineID(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("ROUTE_NO").item(0).getFirstChild().getNodeValue());
			info.setBusType(element.getElementsByTagName("ROUTE_TP").item(0).getFirstChild().getNodeValue().substring(0, 1));

			BusStopInfoType startPoint = new BusStopInfoType();
			BusStopInfoType endPoint = new BusStopInfoType();
			BusStopInfoType turnPoint = new BusStopInfoType();
			if(element.getElementsByTagName("START_NODE_ID").item(0) != null) {
				startPoint.setStopID(element.getElementsByTagName("START_NODE_ID").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("START_STOP_ID").item(0) != null) {
				startPoint.setNumber(element.getElementsByTagName("START_STOP_ID").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("END_NODE_ID").item(0) != null) {
				endPoint.setStopID(element.getElementsByTagName("END_NODE_ID").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("END_STOP_ID").item(0) != null) {
				endPoint.setNumber(element.getElementsByTagName("END_STOP_ID").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("TURN_NODE_ID").item(0) != null) {
				turnPoint.setStopID(element.getElementsByTagName("TURN_NODE_ID").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("TURN_STOP_ID").item(0) != null) {
				turnPoint.setNumber(element.getElementsByTagName("TURN_STOP_ID").item(0).getFirstChild().getNodeValue());
			}
			info.setStartPoint(startPoint);
			info.setEndPoint(endPoint);
			info.setTurnPoint(turnPoint);

			BusTimeType startTime = new BusTimeType();
			BusTimeType endTime = new BusTimeType();
			BusTimeType turnStartTime = new BusTimeType();
			BusTimeType turnEndTime = new BusTimeType();
			if(element.getElementsByTagName("ORIGIN_START").item(0) != null) {
				startTime.setTime(element.getElementsByTagName("ORIGIN_START").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("ORIGIN_START_SAT").item(0) != null) {
				startTime.setTimeSat(element.getElementsByTagName("ORIGIN_START_SAT").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("ORIGIN_START_SUN").item(0) != null) {
				startTime.setTimeSun(element.getElementsByTagName("ORIGIN_START_SUN").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("ORIGIN_END").item(0) != null) {
				endTime.setTime(element.getElementsByTagName("ORIGIN_END").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("ORIGIN_END_SAT").item(0) != null) {
				endTime.setTimeSat(element.getElementsByTagName("ORIGIN_END_SAT").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("ORIGIN_END_SUN").item(0) != null) {
				endTime.setTimeSun(element.getElementsByTagName("ORIGIN_END_SUN").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("TURN_START").item(0) != null) {
				turnStartTime.setTime(element.getElementsByTagName("TURN_START").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("TURN_START_SAT").item(0) != null) {
				turnStartTime.setTimeSat(element.getElementsByTagName("TURN_START_SAT").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("TURN_START_SUN").item(0) != null) {
				turnStartTime.setTimeSun(element.getElementsByTagName("TURN_START_SUN").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("TURN_END").item(0) != null) {
				turnEndTime.setTime(element.getElementsByTagName("TURN_END").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("TURN_END_SAT").item(0) != null) {
				turnEndTime.setTimeSat(element.getElementsByTagName("TURN_END_SAT").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("TURN_END_SUN").item(0) != null) {
				turnEndTime.setTimeSun(element.getElementsByTagName("TURN_END_SUN").item(0).getFirstChild().getNodeValue());
			}
			info.setStartTime(startTime);
			info.setEndTime(endTime);
			info.setTurnStartTime(turnStartTime);
			info.setTurnEndTime(turnEndTime);

			BusIntervalType interval = new BusIntervalType();
			if(element.getElementsByTagName("ALLO_INTERVAL").item(0) != null) {
				interval.setInterval(element.getElementsByTagName("ALLO_INTERVAL").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("ALLO_INTERVAL_SAT").item(0) != null) {
				interval.setIntervalSat(element.getElementsByTagName("ALLO_INTERVAL_SAT").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("ALLO_INTERVAL_SUN").item(0) != null) {
				interval.setIntervalSun(element.getElementsByTagName("ALLO_INTERVAL_SUN").item(0).getFirstChild().getNodeValue());
			}
			info.setInterval(interval);

			if(element.getElementsByTagName("BUSSTOP_CNT").item(0) != null) {
				info.setStopCount(element.getElementsByTagName("BUSSTOP_CNT").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("RUN_DIST_HALF").item(0) != null) {
				info.setHalfDistance(element.getElementsByTagName("RUN_DIST_HALF").item(0).getFirstChild().getNodeValue());
			}
			if(element.getElementsByTagName("RUN_TM").item(0) != null) {
				info.setAvgRunTime(element.getElementsByTagName("RUN_TM").item(0).getFirstChild().getNodeValue().substring(0, 2));
			}

			infoList.add(info);
		}

		return infoList;
	}

	private List<BusStopInfoType> translateDaejeonBusStopInfo(String data) {

		List<BusStopInfoType> infoList = new ArrayList<BusStopInfoType>();

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("itemList");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusStopInfoType info = new BusStopInfoType();

			DAOFactory factory = new DAOFactory();
			DataAccessObject dao = factory.getDAO(DAOFactory.GLN);
			info.setGln(dao.queryKey(element.getElementsByTagName("BUS_NODE_ID").item(0).getFirstChild().getNodeValue()));

			//info.setGln("8801234123456");

			info.setStopID(element.getElementsByTagName("BUS_NODE_ID").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("ARO_BUSSTOP_ID").item(0).getFirstChild().getNodeValue());
			info.setNameKR(element.getElementsByTagName("BUSSTOP_NM").item(0).getFirstChild().getNodeValue());
			info.setNameEN(element.getElementsByTagName("BUSSTOP_ENG_NM").item(0).getFirstChild().getNodeValue());
			info.setGpsX(element.getElementsByTagName("GPS_LONG").item(0).getFirstChild().getNodeValue());
			info.setGpsY(element.getElementsByTagName("GPS_LATI").item(0).getFirstChild().getNodeValue());
			info.setRoad(element.getElementsByTagName("ROAD_NM").item(0).getFirstChild().getNodeValue());
			info.setAddr(element.getElementsByTagName("ROAD_NM_ADDR").item(0).getFirstChild().getNodeValue());
			info.setLines(element.getElementsByTagName("ROUTE_NO").item(0).getFirstChild().getNodeValue());

			infoList.add(info);
		}

		return infoList;
	}

	private BusLineRouteType translateDaejeonBusLineRouteInfo(String data) {

		String dataBody = data.substring(data.lastIndexOf("<?xml"));
		String key = data.substring(0, data.lastIndexOf("<?xml"));

		try {
			document = builder.parse(new InputSource(new StringReader(dataBody)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("itemList");

		BusLineRouteType info = new BusLineRouteType();

		DAOFactory factory = new DAOFactory();
		DataAccessObject dao = factory.getDAO(DAOFactory.GSRN);
		info.setGsrn(dao.queryKey(key));

		//info.setGsrn("8801234123456");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusRouteStopInfoType bsinfo = new BusRouteStopInfoType();
			bsinfo.setIndex(i+1);
			bsinfo.setStopID(element.getElementsByTagName("BUS_NODE_ID").item(0).getFirstChild().getNodeValue());
			bsinfo.setNumber(element.getElementsByTagName("BUS_STOP_ID").item(0).getFirstChild().getNodeValue());
			bsinfo.setNameKR(element.getElementsByTagName("BUSSTOP_NM").item(0).getFirstChild().getNodeValue());
			bsinfo.setNameEN(element.getElementsByTagName("BUSSTOP_ENG_NM").item(0).getFirstChild().getNodeValue());

			info.getStopList().add(bsinfo);
		}

		return info;
	}

	public List<BusCompanyInfoType> translateDaejeonBusCompanyInfo(String data) {

		List<BusCompanyInfoType> infoList = new ArrayList<BusCompanyInfoType>();

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("itemList");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusCompanyInfoType info = new BusCompanyInfoType();

			//			DAOFactory factory = new DAOFactory();
			//			DataAccessObject dao = factory.getDAO(DAOFactory.GLN);
			//			info.setGln(dao.queryKey(element.getElementsByTagName("COMP_CD").item(0).getFirstChild().getNodeValue()));

			info.setGln("8801234123456");

			info.setCompanyID(element.getElementsByTagName("COMP_CD").item(0).getFirstChild().getNodeValue());
			info.setName(element.getElementsByTagName("COMP_NM").item(0).getFirstChild().getNodeValue());
			info.setAddr(element.getElementsByTagName("ADDR1").item(0).getFirstChild().getNodeValue());
			info.setTel(element.getElementsByTagName("TEL_NO").item(0).getFirstChild().getNodeValue());

			infoList.add(info);
		}

		return infoList;
	}

}
