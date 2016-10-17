package org.gs1.smartcity.capturing.services.bus;

import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.eventdata.BusEventDataManager;
import org.gs1.smartcity.capturing.masterdata.BusMasterDataManager;
import org.gs1.smartcity.capturing.services.Translator;
import org.gs1.smartcity.datatype.bus.BusIntervalType;
import org.gs1.smartcity.datatype.bus.BusLineInfoType;
import org.gs1.smartcity.datatype.bus.BusStopInfoType;
import org.gs1.smartcity.datatype.bus.BusTimeType;

public class BusTranslator extends Translator {

	public BusTranslator() {

		mdm = new BusMasterDataManager();
		edm = new BusEventDataManager();
	}

	public VocabularyType masterDataTranslate(String type, String data)  {

		if (type.compareTo(BusInfoFactory.BUSAN_BUS_LINE_INFO) == 0) {
			return busanBusLineInfo(data);
		} else if (type.compareTo(BusInfoFactory.BUSAN_BUS_STOP_INFO) == 0) {
			return busanBusStopInfo(data);
		} else if (type.compareTo(BusInfoFactory.BUSAN_BUS_LINE_ROUTE) == 0) {

		} else if (type.compareTo(BusInfoFactory.BUSAN_BUS_STOP_ARR) == 0) {

		} else if (type.compareTo(BusInfoFactory.BUSAN_BUS_LINE_STOP) == 0) {

		} else if (type.compareTo(BusInfoFactory.DAEJEON_BUS_LINE_INFO) == 0) {
			return daejeonBusLineInfo(data);
		} else if (type.compareTo(BusInfoFactory.DAEJEON_BUS_STOP_INFO) == 0) {
			return daejeonBusStopInfo(data);
		}

		return null;
	}

	private VocabularyType busanBusLineInfo(String data) {

		BusLineInfoType info = new BusLineInfoType();

		info.setGsrn("8801234123456789");
		info.setLineID(data.substring(data.lastIndexOf("<lineId>") + "<lineId>".length(), data.lastIndexOf("</lineId>")));
		info.setNumber(data.substring(data.lastIndexOf("<buslinenum>") + "<buslinenum>".length(), data.lastIndexOf("</buslinenum>")));
		info.setBusType(data.substring(data.lastIndexOf("<bustype>") + "<bustype>".length(), data.lastIndexOf("</bustype>")));
		info.setCompany(data.substring(data.lastIndexOf("<companyid>") + "<companyid>".length(), data.lastIndexOf("</companyid>")));

		BusStopInfoType startPoint = new BusStopInfoType();
		BusStopInfoType endPoint = new BusStopInfoType();
		startPoint.setNameKR(data.substring(data.lastIndexOf("<startpoint>") + "<startpoint>".length(), data.lastIndexOf("</startpoint>")));
		endPoint.setNameKR(data.substring(data.lastIndexOf("<endpoint>") + "<endpoint>".length(), data.lastIndexOf("</endpoint>")));
		info.setStartPoint(startPoint);
		info.setEndPoint(endPoint);

		BusTimeType startTime = new BusTimeType();
		BusTimeType endTime = new BusTimeType();
		startTime.setTime(data.substring(data.lastIndexOf("<firsttime>") + "<firsttime>".length(), data.lastIndexOf("</firsttime>")));
		endTime.setTime(data.substring(data.lastIndexOf("<endtime>") + "<endtime>".length(), data.lastIndexOf("</endtime>")));
		info.setStartTime(startTime);
		info.setEndTime(endTime);

		BusIntervalType interval = new BusIntervalType();
		interval.setInterval(data.substring(data.lastIndexOf("<headway>") + "<headway>".length(), data.lastIndexOf("</headway>")));
		interval.setIntervalNorm(data.substring(data.lastIndexOf("<headwayNorm>") + "<headwayNorm>".length(), data.lastIndexOf("</headwayNorm>")));
		interval.setIntervalPeak(data.substring(data.lastIndexOf("<headwayPeak>") + "<headwayPeak>".length(), data.lastIndexOf("</headwayPeak>")));

		VocabularyType voc = new VocabularyType();
		voc = mdm.modelingVocabulary(BusInfoFactory.BUS_LINE_INFO, info);

		return voc;
	}

	private VocabularyType busanBusStopInfo(String data) {

		BusStopInfoType info = new BusStopInfoType();

		info.setGln("8801234123456");
		info.setStopID(data.substring(data.lastIndexOf("<bstopId>") + "<bstopId>".length(), data.lastIndexOf("</bstopId>")));
		info.setNumber(data.substring(data.lastIndexOf("<bstopArsno>") + "<bstopArsno>".length(), data.lastIndexOf("</bstopArsno>")));
		info.setNameKR(data.substring(data.lastIndexOf("<bstopNm>") + "<bstopNm>".length(), data.lastIndexOf("</bstopNm>")));
		info.setGpsX(data.substring(data.lastIndexOf("<gpsX>") + "<gpsX>".length(), data.lastIndexOf("</gpsX>")));
		info.setGpsY(data.substring(data.lastIndexOf("<gpsY>") + "<gpsY>".length(), data.lastIndexOf("</gpsY>")));

		VocabularyType voc = new VocabularyType();
		voc = mdm.modelingVocabulary(BusInfoFactory.BUS_STOP_INFO, info);

		return voc;
	}

	private VocabularyType daejeonBusLineInfo(String data) {

		BusLineInfoType info = new BusLineInfoType();

		info.setGsrn("8801234123456789");
		info.setLineID(data.substring(data.lastIndexOf("<ROUTE_CD>") + "<ROUTE_CD>".length(), data.lastIndexOf("</ROUTE_CD>")));
		info.setNumber(data.substring(data.lastIndexOf("<ROUTE_NO>") + "<ROUTE_NO>".length(), data.lastIndexOf("</ROUTE_NO>")));
		info.setBusType(data.substring(data.lastIndexOf("<ROUTE_TP>") + "<ROUTE_TP>".length(), data.lastIndexOf("</ROUTE_TP>")));

		BusStopInfoType startPoint = new BusStopInfoType();
		BusStopInfoType endPoint = new BusStopInfoType();
		BusStopInfoType turnPoint = new BusStopInfoType();
		startPoint.setStopID(data.substring(data.lastIndexOf("<START_NODE_ID>") + "<START_NODE_ID>".length(), data.lastIndexOf("</START_NODE_ID>")));
		startPoint.setNumber(data.substring(data.lastIndexOf("<START_STOP_ID>") + "<START_STOP_ID>".length(), data.lastIndexOf("</START_STOP_ID>")));
		endPoint.setStopID(data.substring(data.lastIndexOf("<END_NODE_ID>") + "<END_NODE_ID>".length(), data.lastIndexOf("</END_NODE_ID>")));
		endPoint.setNumber(data.substring(data.lastIndexOf("<END_STOP_ID>") + "<END_STOP_ID>".length(), data.lastIndexOf("</END_STOP_ID>")));
		turnPoint.setStopID(data.substring(data.lastIndexOf("<TURN_NODE_ID>") + "<TURN_NODE_ID>".length(), data.lastIndexOf("</TURN_NODE_ID>")));
		turnPoint.setNumber(data.substring(data.lastIndexOf("<TURN_STOP_ID>") + "<TURN_STOP_ID>".length(), data.lastIndexOf("</TURN_STOP_ID>")));
		info.setStartPoint(startPoint);
		info.setEndPoint(endPoint);
		info.setTurnPoint(turnPoint);

		BusTimeType startTime = new BusTimeType();
		BusTimeType endTime = new BusTimeType();
		BusTimeType turnStartTime = new BusTimeType();
		BusTimeType turnEndTime = new BusTimeType();
		startTime.setTime(data.substring(data.lastIndexOf("<ORIGIN_START>") + "<ORIGIN_START>".length(), data.lastIndexOf("</ORIGIN_START>")));
		startTime.setTimeSat(data.substring(data.lastIndexOf("<ORIGIN_START_SAT>") + "<ORIGIN_START_SAT>".length(), data.lastIndexOf("</ORIGIN_START_SAT>")));
		startTime.setTimeSun(data.substring(data.lastIndexOf("<ORIGIN_START_SUN>") + "<ORIGIN_START_SUN>".length(), data.lastIndexOf("</ORIGIN_START_SUN>")));
		endTime.setTime(data.substring(data.lastIndexOf("<ORIGIN_END>") + "<ORIGIN_END>".length(), data.lastIndexOf("</ORIGIN_END>")));
		endTime.setTimeSat(data.substring(data.lastIndexOf("<ORIGIN_END_SAT>") + "<ORIGIN_END_SAT>".length(), data.lastIndexOf("</ORIGIN_END_SAT>")));
		endTime.setTimeSun(data.substring(data.lastIndexOf("<ORIGIN_END_SUN>") + "<ORIGIN_END_SUN>".length(), data.lastIndexOf("</ORIGIN_END_SUN>")));
		turnStartTime.setTime(data.substring(data.lastIndexOf("<TURN_START>") + "<TURN_START>".length(), data.lastIndexOf("</TURN_START>")));
		turnStartTime.setTimeSat(data.substring(data.lastIndexOf("<TURN_START_SAT>") + "<TURN_START_SAT>".length(), data.lastIndexOf("</TURN_START_SAT>")));
		turnStartTime.setTimeSun(data.substring(data.lastIndexOf("<TURN_START_SUN>") + "<TURN_START_SUN>".length(), data.lastIndexOf("</TURN_START_SUN>")));
		turnEndTime.setTime(data.substring(data.lastIndexOf("<TURN_END>") + "<TURN_END>".length(), data.lastIndexOf("</TURN_END>")));
		turnEndTime.setTimeSat(data.substring(data.lastIndexOf("<TURN_END_SAT>") + "<TURN_END_SAT>".length(), data.lastIndexOf("</TURN_END_SAT>")));
		turnEndTime.setTimeSun(data.substring(data.lastIndexOf("<TURN_END_SUN>") + "<TURN_END_SUN>".length(), data.lastIndexOf("</TURN_END_SUN>")));
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setTurnStartTime(turnStartTime);
		info.setTurnEndTime(turnEndTime);

		BusIntervalType interval = new BusIntervalType();
		interval.setInterval(data.substring(data.lastIndexOf("<ALLO_INTERVAL>") + "<ALLO_INTERVAL>".length(), data.lastIndexOf("</ALLO_INTERVAL>")));
		interval.setIntervalSat(data.substring(data.lastIndexOf("<ALLO_INTERVAL_SAT>") + "<ALLO_INTERVAL_SAT>".length(), data.lastIndexOf("</ALLO_INTERVAL_SAT>")));
		interval.setIntervalSun(data.substring(data.lastIndexOf("<ALLO_INTERVAL_SUN>") + "<ALLO_INTERVAL_SUN>".length(), data.lastIndexOf("</ALLO_INTERVAL_SUN>")));
		info.setInterval(interval);

		info.setStopCount(Integer.parseInt(data.substring(data.lastIndexOf("<BUSSTOP_CNT>") + "<BUSSTOP_CNT>".length(), data.lastIndexOf("</BUSSTOP_CNT>"))));
		info.setHalfDistance(data.substring(data.lastIndexOf("<RUN_DIST_HALF>") + "<RUN_DIST_HALF>".length(), data.lastIndexOf("</RUN_DIST_HALF")));
		info.setAvgRunTime(Integer.parseInt(data.substring(data.lastIndexOf("<RUN_TM>") + "<RUN_TM>".length(), data.lastIndexOf("</RUN_TM>"))));

		VocabularyType voc = new VocabularyType();
		voc = mdm.modelingVocabulary(BusInfoFactory.BUS_LINE_INFO, info);

		return voc;
	}

	private VocabularyType daejeonBusStopInfo(String data) {

		BusStopInfoType info = new BusStopInfoType();

		info.setGln("8801234123456");
		info.setStopID(data.substring(data.lastIndexOf("<BUS_NODE_ID>") + "<BUS_NODE_ID>".length(), data.lastIndexOf("</BUS_NODE_ID>")));
		info.setNumber(data.substring(data.lastIndexOf("<ARO_BUSSTOP_ID>") + "<ARO_BUSSTOP_ID>".length(), data.lastIndexOf("</ARO_BUSSTOP_ID>")));
		info.setNameKR(data.substring(data.lastIndexOf("<BUSSTOP_NM>") + "<BUSSTOP_NM>".length(), data.lastIndexOf("</BUSSTOP_NM>")));
		info.setNameEN(data.substring(data.lastIndexOf("<BUSSTOP_ENG_NM>") + "<BUSSTOP_ENG_NM>".length(), data.lastIndexOf("</BUSSTOP_ENG_NM>")));
		info.setGpsX(data.substring(data.lastIndexOf("<GPS_LONG>") + "<GPS_LONG>".length(), data.lastIndexOf("</GPS_LONG>")));
		info.setGpsY(data.substring(data.lastIndexOf("<GPS_LATI>") + "<GPS_LATI>".length(), data.lastIndexOf("</GPS_LATI>")));
		info.setRoad(data.substring(data.lastIndexOf("<ROAD_NM>") + "<ROAD_NM>".length(), data.lastIndexOf("</ROAD_NM>")));
		info.setAddr(data.substring(data.lastIndexOf("<ROAD_NM_ADDR>") + "<ROAD_NM_ADDR>".length(), data.lastIndexOf("</ROAD_NM_ADDR>")));
		info.setLines(data.substring(data.lastIndexOf("<ROUTE_NO>") + "<ROUTE_NO>".length(), data.lastIndexOf("</ROUTE_NO>")));

		VocabularyType voc = new VocabularyType();
		voc = mdm.modelingVocabulary(BusInfoFactory.BUS_STOP_INFO, info);

		return voc;
	}

	public ObjectEventType eventDataTranslate(String type, String data) {


		return null;
	}

}
