package org.gs1.smartcity.capturing.services.bus;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.epcglobal.epcis.VocabularyListType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.masterdata.BusMasterDataManager;
import org.gs1.smartcity.capturing.services.VocabularyTranslator;
import org.gs1.smartcity.datatype.bus.BusIntervalType;
import org.gs1.smartcity.datatype.bus.BusLineInfo;
import org.gs1.smartcity.datatype.bus.BusLineRoute;
import org.gs1.smartcity.datatype.bus.BusRouteStopInfo;
import org.gs1.smartcity.datatype.bus.BusStopInfo;
import org.gs1.smartcity.datatype.bus.BusTimeType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class BusVocabularyTranslator extends VocabularyTranslator {

	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document document;

	public BusVocabularyTranslator() throws ParserConfigurationException {

		mdm = new BusMasterDataManager();

		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}

	public VocabularyListType translate(String type, String data)  {

		if (type.compareTo(BusServiceFactory.BUSAN_BUS_LINE_INFO) == 0 || type.compareTo(BusServiceFactory.BUSAN_BUS_LINE_INFO_ALL) == 0) {
			try {
				return busanBusLineInfo(data);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (type.compareTo(BusServiceFactory.BUSAN_BUS_STOP_INFO) == 0) {
			try {
				return busanBusStopInfo(data);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (type.compareTo(BusServiceFactory.BUSAN_BUS_LINE_ROUTE) == 0) {
			try {
				return busanBusLineRouteInfo(data);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (type.compareTo(BusServiceFactory.BUSAN_BUS_STOP_ARR) == 0) {

		} else if (type.compareTo(BusServiceFactory.BUSAN_BUS_LINE_STOP) == 0) {

		} else if (type.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_INFO) == 0 || type.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_INFO_ALL) == 0) {
			try {
				return daejeonBusLineInfo(data);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (type.compareTo(BusServiceFactory.DAEJEON_BUS_STOP_INFO) == 0) {
			try {
				return daejeonBusStopInfo(data);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (type.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_ROUTE) == 0) {
			try {
				return daejeonBusLineRouteInfo(data);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (type.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_ROUTE_ALL) == 0) {
			try {
				return daejeonBusLineInfoAll(data);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	private VocabularyListType busanBusLineInfo(String data) throws SAXException, IOException {

		VocabularyListType vocList = new VocabularyListType();

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusLineInfo info = new BusLineInfo();
			info.setGsrn("8801234123456789");

			info.setLineID(element.getElementsByTagName("lineId").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("buslinenum").item(0).getFirstChild().getNodeValue());
			info.setBusType(element.getElementsByTagName("bustype").item(0).getFirstChild().getNodeValue());
			info.setCompany(element.getElementsByTagName("companyid").item(0).getFirstChild().getNodeValue());

			BusStopInfo startPoint = new BusStopInfo();
			BusStopInfo endPoint = new BusStopInfo();
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

			VocabularyType voc = new VocabularyType();
			voc = mdm.modelingVocabulary(BusServiceFactory.BUS_LINE_INFO, info);
			vocList.getVocabularies().add(voc);
		}

		return vocList;
	}

	private VocabularyListType busanBusStopInfo(String data) throws SAXException, IOException {

		VocabularyListType vocList = new VocabularyListType();

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusStopInfo info = new BusStopInfo();
			info.setGln("8801234123456");

			info.setStopID(element.getElementsByTagName("bstopId").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("bstopArsno").item(0).getFirstChild().getNodeValue());
			info.setNameKR(element.getElementsByTagName("bstopNm").item(0).getFirstChild().getNodeValue());
			info.setGpsX(element.getElementsByTagName("gpsX").item(0).getFirstChild().getNodeValue());
			info.setGpsY(element.getElementsByTagName("gpsY").item(0).getFirstChild().getNodeValue());

			VocabularyType voc = new VocabularyType();
			voc = mdm.modelingVocabulary(BusServiceFactory.BUS_STOP_INFO, info);
			vocList.getVocabularies().add(voc);
		}

		return vocList;
	}

	private VocabularyListType busanBusLineRouteInfo(String data) throws SAXException, IOException {

		VocabularyListType vocList = new VocabularyListType();

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("item");

		BusLineRoute info = new BusLineRoute();
		info.setGsrn("8801234123456789");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusRouteStopInfo bsinfo = new BusRouteStopInfo();
			bsinfo.setIndex(i+1);
			bsinfo.setStopID(element.getElementsByTagName("nodeId").item(0).getFirstChild().getNodeValue());
			bsinfo.setNumber(element.getElementsByTagName("arsNo").item(0).getFirstChild().getNodeValue());
			bsinfo.setNameKR(element.getElementsByTagName("bstopnm").item(0).getFirstChild().getNodeValue());

			info.getStopList().add(bsinfo);
		}

		VocabularyType voc = new VocabularyType();
		voc = mdm.modelingVocabulary(BusServiceFactory.BUS_LINE_ROUTE, info);
		vocList.getVocabularies().add(voc);

		return vocList;
	}

	private VocabularyListType daejeonBusLineInfo(String data) throws SAXException, IOException {

		VocabularyListType vocList = new VocabularyListType();

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("itemList");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusLineInfo info = new BusLineInfo();
			info.setGsrn("8801234123456789");

			info.setLineID(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("ROUTE_NO").item(0).getFirstChild().getNodeValue());
			info.setBusType(element.getElementsByTagName("ROUTE_TP").item(0).getFirstChild().getNodeValue().substring(0, 1));

			BusStopInfo startPoint = new BusStopInfo();
			BusStopInfo endPoint = new BusStopInfo();
			BusStopInfo turnPoint = new BusStopInfo();
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

			VocabularyType voc = new VocabularyType();
			voc = mdm.modelingVocabulary(BusServiceFactory.BUS_LINE_INFO, info);
			vocList.getVocabularies().add(voc);
		}

		return vocList;
	}

	private VocabularyListType daejeonBusStopInfo(String data) throws SAXException, IOException {

		VocabularyListType vocList = new VocabularyListType();

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("itemList");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusStopInfo info = new BusStopInfo();
			info.setGln("8801234123456");

			info.setStopID(element.getElementsByTagName("BUS_NODE_ID").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("ARO_BUSSTOP_ID").item(0).getFirstChild().getNodeValue());
			info.setNameKR(element.getElementsByTagName("BUSSTOP_NM").item(0).getFirstChild().getNodeValue());
			info.setNameEN(element.getElementsByTagName("BUSSTOP_ENG_NM").item(0).getFirstChild().getNodeValue());
			info.setGpsX(element.getElementsByTagName("GPS_LONG").item(0).getFirstChild().getNodeValue());
			info.setGpsY(element.getElementsByTagName("GPS_LATI").item(0).getFirstChild().getNodeValue());
			info.setRoad(element.getElementsByTagName("ROAD_NM").item(0).getFirstChild().getNodeValue());
			info.setAddr(element.getElementsByTagName("ROAD_NM_ADDR").item(0).getFirstChild().getNodeValue());
			info.setLines(element.getElementsByTagName("ROUTE_NO").item(0).getFirstChild().getNodeValue());

			VocabularyType voc = new VocabularyType();
			voc = mdm.modelingVocabulary(BusServiceFactory.BUS_STOP_INFO, info);
			vocList.getVocabularies().add(voc);
		}

		return vocList;
	}

	private VocabularyListType daejeonBusLineRouteInfo(String data) throws SAXException, IOException {

		VocabularyListType vocList = new VocabularyListType();

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("itemList");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusLineRoute info = new BusLineRoute();
			info.setGsrn("8801234123456789");

			BusRouteStopInfo bsinfo = new BusRouteStopInfo();
			bsinfo.setIndex(i+1);
			bsinfo.setStopID(element.getElementsByTagName("BUS_NODE_ID").item(0).getFirstChild().getNodeValue());
			bsinfo.setNumber(element.getElementsByTagName("BUS_STOP_ID").item(0).getFirstChild().getNodeValue());
			bsinfo.setNameKR(element.getElementsByTagName("BUSSTOP_NM").item(0).getFirstChild().getNodeValue());
			bsinfo.setNameEN(element.getElementsByTagName("BUSSTOP_ENG_NM").item(0).getFirstChild().getNodeValue());

			info.getStopList().add(bsinfo);

			VocabularyType voc = new VocabularyType();
			voc = mdm.modelingVocabulary(BusServiceFactory.BUS_LINE_ROUTE, info);
			vocList.getVocabularies().add(voc);
		}

		return vocList;
	}

	private VocabularyListType daejeonBusLineInfoAll(String data) throws SAXException, IOException {

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("itemList");

		VocabularyListType vocList = new VocabularyListType();

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			BusLineInfo info = new BusLineInfo();
			info.setGsrn("8801234123456789");

			info.setLineID(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue());
			info.setNumber(element.getElementsByTagName("ROUTE_NO").item(0).getFirstChild().getNodeValue());
			info.setBusType(element.getElementsByTagName("ROUTE_TP").item(0).getFirstChild().getNodeValue());

			BusStopInfo startPoint = new BusStopInfo();
			BusStopInfo endPoint = new BusStopInfo();
			BusStopInfo turnPoint = new BusStopInfo();
			startPoint.setStopID(element.getElementsByTagName("START_NODE_ID").item(0).getFirstChild().getNodeValue());
			startPoint.setNumber(element.getElementsByTagName("START_STOP_ID").item(0).getFirstChild().getNodeValue());
			endPoint.setStopID(element.getElementsByTagName("END_NODE_ID").item(0).getFirstChild().getNodeValue());
			endPoint.setNumber(element.getElementsByTagName("END_STOP_ID").item(0).getFirstChild().getNodeValue());
			turnPoint.setStopID(element.getElementsByTagName("TURN_NODE_ID").item(0).getFirstChild().getNodeValue());
			turnPoint.setNumber(element.getElementsByTagName("TURN_STOP_ID").item(0).getFirstChild().getNodeValue());
			info.setStartPoint(startPoint);
			info.setEndPoint(endPoint);
			info.setTurnPoint(turnPoint);

			BusTimeType startTime = new BusTimeType();
			BusTimeType endTime = new BusTimeType();
			BusTimeType turnStartTime = new BusTimeType();
			BusTimeType turnEndTime = new BusTimeType();
			startTime.setTime(element.getElementsByTagName("ORIGIN_START").item(0).getFirstChild().getNodeValue());
			startTime.setTimeSat(element.getElementsByTagName("ORIGIN_START_SAT").item(0).getFirstChild().getNodeValue());
			startTime.setTimeSun(element.getElementsByTagName("ORIGIN_START_SUN").item(0).getFirstChild().getNodeValue());
			endTime.setTime(element.getElementsByTagName("ORIGIN_END").item(0).getFirstChild().getNodeValue());
			endTime.setTimeSat(element.getElementsByTagName("ORIGIN_END_SAT").item(0).getFirstChild().getNodeValue());
			endTime.setTimeSun(element.getElementsByTagName("ORIGIN_END_SUN").item(0).getFirstChild().getNodeValue());
			turnStartTime.setTime(element.getElementsByTagName("TURN_START").item(0).getFirstChild().getNodeValue());
			turnStartTime.setTimeSat(element.getElementsByTagName("TURN_START_SAT").item(0).getFirstChild().getNodeValue());
			turnStartTime.setTimeSun(element.getElementsByTagName("TURN_START_SUN").item(0).getFirstChild().getNodeValue());
			turnEndTime.setTime(element.getElementsByTagName("TURN_END").item(0).getFirstChild().getNodeValue());
			turnEndTime.setTimeSat(element.getElementsByTagName("TURN_END_SAT").item(0).getFirstChild().getNodeValue());
			turnEndTime.setTimeSun(element.getElementsByTagName("TURN_END_SUN").item(0).getFirstChild().getNodeValue());
			info.setStartTime(startTime);
			info.setEndTime(endTime);
			info.setTurnStartTime(turnStartTime);
			info.setTurnEndTime(turnEndTime);

			BusIntervalType interval = new BusIntervalType();
			interval.setInterval(element.getElementsByTagName("ALLO_INTERVAL").item(0).getFirstChild().getNodeValue());
			interval.setIntervalSat(element.getElementsByTagName("ALLO_INTERVAL_SAT").item(0).getFirstChild().getNodeValue());
			interval.setIntervalSun(element.getElementsByTagName("ALLO_INTERVAL_SUN").item(0).getFirstChild().getNodeValue());
			info.setInterval(interval);

			info.setStopCount(element.getElementsByTagName("BUSSTOP_CNT").item(0).getFirstChild().getNodeValue());
			info.setHalfDistance(element.getElementsByTagName("RUN_DIST_HALF").item(0).getFirstChild().getNodeValue());
			info.setAvgRunTime(element.getElementsByTagName("RUN_TM").item(0).getFirstChild().getNodeValue());

			VocabularyType voc = new VocabularyType();
			voc = mdm.modelingVocabulary(BusServiceFactory.BUS_LINE_ROUTE, info);
			vocList.getVocabularies().add(voc);
		}

		return vocList;
	}

}
