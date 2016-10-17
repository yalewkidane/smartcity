package org.gs1.smartcity.capturing.masterdata;

import org.gs1.epcglobal.epcis.AttributeType;
import org.gs1.epcglobal.epcis.VocabularyElementListType;
import org.gs1.epcglobal.epcis.VocabularyElementType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.services.bus.BusInfoFactory;
import org.gs1.smartcity.datatype.bus.BusCompanyInfoType;
import org.gs1.smartcity.datatype.bus.BusDriverInfoType;
import org.gs1.smartcity.datatype.bus.BusLineInfoType;
import org.gs1.smartcity.datatype.bus.BusStopInfoType;

public class BusMasterDataManager extends MasterDataManager {

	public VocabularyType modelingVocabulary(String type, Object object) {

		if (type.compareTo(BusInfoFactory.BUS_LINE_INFO) == 0) {
			lineModeling((BusLineInfoType) object);
		} else if (type.compareTo(BusInfoFactory.BUS_STOP_INFO) == 0) {
			stopModeling((BusStopInfoType) object);
		} else if (type.compareTo(BusInfoFactory.BUS_DRIVER_INFO) == 0) {
			driverModeling((BusDriverInfoType) object);
		} else if (type.compareTo(BusInfoFactory.BUS_COMPANY_INFO) == 0) {
			companyModeling((BusCompanyInfoType) object);
		}

		return voc;
	}

	private void lineModeling(BusLineInfoType info) {

		//vocabulary type
		voc.setType("urn:gs1:epcisapp:bus:line:info");

		//vocabulary element with gsrn
		VocabularyElementListType vocElementList = new VocabularyElementListType();
		VocabularyElementType vocElement = new VocabularyElementType();
		vocElement.setId("urn:epc:id:gsrn:" + info.getGsrn().substring(0, 6) + "." + info.getGsrn().substring(7));

		//bus line id
		AttributeType lineid = new AttributeType();
		lineid.setId("http://epcis.example.com/bus/line/id");
		lineid.getContent().add(info.getLineID());
		vocElement.getAttributes().add(lineid);

		//bus line number
		AttributeType number = new AttributeType();
		number.setId("http://epcis.example.com/bus/line/number");
		number.getContent().add(info.getNumber());
		vocElement.getAttributes().add(number);

		//bus type
		AttributeType busType = new AttributeType();
		busType.setId("http://epcis.example.com/bus/line/busType");
		busType.getContent().add(info.getBusType());
		vocElement.getAttributes().add(busType);

		//bus company
		AttributeType company = new AttributeType();
		company.setId("http://epcis.example.com/bus/line/company");
		company.getContent().add(info.getCompany());
		vocElement.getAttributes().add(company);

		//start point
		AttributeType startPoint = new AttributeType();
		startPoint.setId("http://epcis.example.com/bus/line/startPoint");

		if(info.getStartPoint().getNameKR() != null) {
			AttributeType startPoint_name = new AttributeType();
			startPoint_name.setId("http://epcis.example.com/bus/line/startPoint/name_kr");
			startPoint_name.getContent().add(info.getStartPoint().getNameKR());
			startPoint.getContent().add(startPoint_name);
		}
		if(info.getStartPoint().getNameEN() != null) {
			AttributeType startPoint_name = new AttributeType();
			startPoint_name.setId("http://epcis.example.com/bus/line/startPoint/name_en");
			startPoint_name.getContent().add(info.getStartPoint().getNameEN());
			startPoint.getContent().add(startPoint_name);
		}
		if(info.getStartPoint().getStopID() != null) {
			AttributeType startPoint_stopid = new AttributeType();
			startPoint_stopid.setId("http://epcis.example.com/bus/line/startPoint/stopid");
			startPoint_stopid.getContent().add(info.getStartPoint().getStopID());
			startPoint.getContent().add(startPoint_stopid);
		}
		if(info.getStartPoint().getNumber() != null) {
			AttributeType startPoint_number = new AttributeType();
			startPoint_number.setId("http://epcis.example.com/bus/line/startPoint/number");
			startPoint_number.getContent().add(info.getStartPoint().getStopID());
			startPoint.getContent().add(startPoint_number);
		}

		vocElement.getAttributes().add(startPoint);

		//end point
		AttributeType endPoint = new AttributeType();
		endPoint.setId("http://epcis.example.com/bus/line/endPoint");

		if(info.getEndPoint().getNameKR() != null) {
			AttributeType endPoint_name = new AttributeType();
			endPoint_name.setId("http://epcis.example.com/bus/line/endPoint/name_kr");
			endPoint_name.getContent().add(info.getStartPoint().getNameKR());
			endPoint.getContent().add(endPoint_name);
		}
		if(info.getEndPoint().getNameEN() != null) {
			AttributeType endPoint_name = new AttributeType();
			endPoint_name.setId("http://epcis.example.com/bus/line/endPoint/name_en");
			endPoint_name.getContent().add(info.getStartPoint().getNameEN());
			endPoint.getContent().add(endPoint_name);
		}
		if(info.getEndPoint().getStopID() != null) {
			AttributeType endPoint_stopid = new AttributeType();
			endPoint_stopid.setId("http://epcis.example.com/bus/line/endPoint/stopid");
			endPoint_stopid.getContent().add(info.getEndPoint().getStopID());
			endPoint.getContent().add(endPoint_stopid);
		}
		if(info.getEndPoint().getNumber() != null) {
			AttributeType endPoint_number = new AttributeType();
			endPoint_number.setId("http://epcis.example.com/bus/line/endPoint/number");
			endPoint_number.getContent().add(info.getEndPoint().getStopID());
			endPoint.getContent().add(endPoint_number);
		}

		vocElement.getAttributes().add(endPoint);

		//turn point
		if(info.getTurnPoint() != null) {
			AttributeType turnPoint = new AttributeType();
			turnPoint.setId("http://epcis.example.com/bus/line/turnPoint");

			if(info.getTurnPoint().getNameKR() != null) {
				AttributeType turnPoint_name = new AttributeType();
				turnPoint_name.setId("http://epcis.example.com/bus/line/turnPoint/name_kr");
				turnPoint_name.getContent().add(info.getTurnPoint().getNameKR());
				turnPoint.getContent().add(turnPoint_name);
			}
			if(info.getTurnPoint().getNameEN() != null) {
				AttributeType turnPoint_name = new AttributeType();
				turnPoint_name.setId("http://epcis.example.com/bus/line/turnPoint/name_en");
				turnPoint_name.getContent().add(info.getTurnPoint().getNameEN());
				turnPoint.getContent().add(turnPoint_name);
			}
			if(info.getTurnPoint().getStopID() != null) {
				AttributeType turnPoint_stopid = new AttributeType();
				turnPoint_stopid.setId("http://epcis.example.com/bus/line/turnPoint/stopid");
				turnPoint_stopid.getContent().add(info.getTurnPoint().getStopID());
				turnPoint.getContent().add(turnPoint_stopid);
			}
			if(info.getTurnPoint().getNumber() != null) {
				AttributeType turnPoint_number = new AttributeType();
				turnPoint_number.setId("http://epcis.example.com/bus/line/turnPoint/number");
				turnPoint_number.getContent().add(info.getTurnPoint().getStopID());
				turnPoint.getContent().add(turnPoint_number);
			}

			vocElement.getAttributes().add(turnPoint);
		}

		//start time
		AttributeType startTime = new AttributeType();
		startTime.setId("http://epcis.example.com/bus/line/startTime");

		AttributeType startTime_norm = new AttributeType();
		startTime_norm.setId("http://epcis.example.com/bus/line/startTime/norm");
		startTime_norm.getContent().add(info.getStartTime().getTime());
		startTime.getContent().add(startTime_norm);

		if(info.getStartTime().getTimeSat() != null) {
			AttributeType startTime_sat = new AttributeType();
			startTime_sat.setId("http://epcis.example.com/bus/line/startTime/sat");
			startTime_sat.getContent().add(info.getStartTime().getTimeSat());
			startTime.getContent().add(startTime_sat);
		}
		if(info.getStartTime().getTimeSun() != null) {
			AttributeType startTime_sun = new AttributeType();
			startTime_sun.setId("http://epcis.example.com/bus/line/startTime/sun");
			startTime_sun.getContent().add(info.getStartTime().getTimeSun());
			startTime.getContent().add(startTime_sun);
		}

		vocElement.getAttributes().add(startTime);

		//end time
		AttributeType endTime = new AttributeType();
		endTime.setId("http://epcis.example.com/bus/line/endTime");

		AttributeType endTime_norm = new AttributeType();
		endTime_norm.setId("http://epcis.example.com/bus/line/endTime/norm");
		endTime_norm.getContent().add(info.getEndTime().getTime());
		endTime.getContent().add(endTime_norm);

		if(info.getEndTime().getTimeSat() != null) {
			AttributeType endTime_sat = new AttributeType();
			endTime_sat.setId("http://epcis.example.com/bus/line/endTime/sat");
			endTime_sat.getContent().add(info.getEndTime().getTimeSat());
			endTime.getContent().add(endTime_sat);
		}
		if(info.getEndTime().getTimeSun() != null) {
			AttributeType endTime_sun = new AttributeType();
			endTime_sun.setId("http://epcis.example.com/bus/line/endTime/sun");
			endTime_sun.getContent().add(info.getEndTime().getTimeSun());
			endTime.getContent().add(endTime_sun);
		}

		vocElement.getAttributes().add(endTime);

		//turn start time
		if(info.getTurnStartTime() != null) {
			AttributeType turnStartTime = new AttributeType();
			turnStartTime.setId("http://epcis.example.com/bus/line/turnStartTime");

			AttributeType turnStartTime_norm = new AttributeType();
			turnStartTime_norm.setId("http://epcis.example.com/bus/line/turnStartTime/norm");
			turnStartTime_norm.getContent().add(info.getTurnStartTime().getTime());
			turnStartTime.getContent().add(turnStartTime_norm);

			if(info.getTurnStartTime().getTimeSat() != null) {
				AttributeType turnStartTime_sat = new AttributeType();
				turnStartTime_sat.setId("http://epcis.example.com/bus/line/turnStartTime/sat");
				turnStartTime_sat.getContent().add(info.getTurnStartTime().getTimeSat());
				turnStartTime.getContent().add(turnStartTime_sat);
			}
			if(info.getTurnStartTime().getTimeSun() != null) {
				AttributeType turnStartTime_sun = new AttributeType();
				turnStartTime_sun.setId("http://epcis.example.com/bus/line/turnStartTime/sun");
				turnStartTime_sun.getContent().add(info.getTurnStartTime().getTimeSun());
				turnStartTime.getContent().add(turnStartTime_sun);
			}

			vocElement.getAttributes().add(turnStartTime);
		}

		//turn end time
		if(info.getTurnEndTime() != null) {
			AttributeType turnEndTime = new AttributeType();
			turnEndTime.setId("http://epcis.example.com/bus/line/endTime");

			AttributeType turnEndTime_norm = new AttributeType();
			turnEndTime_norm.setId("http://epcis.example.com/bus/line/turnEndTime/norm");
			turnEndTime_norm.getContent().add(info.getTurnEndTime().getTime());
			turnEndTime.getContent().add(turnEndTime_norm);

			if(info.getTurnEndTime().getTimeSat() != null) {
				AttributeType turnEndTime_sat = new AttributeType();
				turnEndTime_sat.setId("http://epcis.example.com/bus/line/turnEndTime/sat");
				turnEndTime_sat.getContent().add(info.getTurnEndTime().getTimeSat());
				turnEndTime.getContent().add(turnEndTime_sat);
			}
			if(info.getTurnEndTime().getTimeSun() != null) {
				AttributeType turnEndTime_sun = new AttributeType();
				turnEndTime_sun.setId("http://epcis.example.com/bus/line/turnEndTime/sun");
				turnEndTime_sun.getContent().add(info.getTurnEndTime().getTimeSun());
				turnEndTime.getContent().add(turnEndTime_sun);
			}

			vocElement.getAttributes().add(turnEndTime);
		}

		//interval
		if(info.getInterval() != null) {
			AttributeType interval = new AttributeType();
			interval.setId("http://epcis.example.com/bus/line/interval");

			if(info.getInterval().getInterval() != null) {
				interval.getContent().add(info.getInterval());
			}

			if(info.getInterval().getIntervalNorm() != null) {
				AttributeType interval_norm = new AttributeType();
				interval_norm.setId("http://epcis.example.com/bus/line/interval/norm");
				interval_norm.getContent().add(info.getInterval().getIntervalNorm());
				interval.getContent().add(interval_norm);
			}

			if(info.getInterval().getIntervalPeak() != null) {
				AttributeType interval_peak = new AttributeType();
				interval_peak.setId("http://epcis.example.com/bus/line/interval/peak");
				interval_peak.getContent().add(info.getInterval().getIntervalPeak());
				interval.getContent().add(interval_peak);
			}

			if(info.getInterval().getIntervalSat() != null) {
				AttributeType interval_sat = new AttributeType();
				interval_sat.setId("http://epcis.example.com/bus/line/interval/sat");
				interval_sat.getContent().add(info.getInterval().getIntervalSat());
				interval.getContent().add(interval_sat);
			}

			if(info.getInterval().getIntervalSun() != null) {
				AttributeType interval_sun = new AttributeType();
				interval_sun.setId("http://epcis.example.com/bus/line/interval/sun");
				interval_sun.getContent().add(info.getInterval().getIntervalSun());
				interval.getContent().add(interval_sun);
			}

			vocElement.getAttributes().add(interval);
		}

		//stop count
		if(info.getStopCount() != 0) {
			AttributeType stopCount = new AttributeType();
			stopCount.setId("http://epcis.example.com/bus/line/stopCount");
			stopCount.getContent().add(info.getStopCount());
			vocElement.getAttributes().add(stopCount);
		}

		//stop count
		if(info.getHalfDistance() != null) {
			AttributeType halfDistance = new AttributeType();
			halfDistance.setId("http://epcis.example.com/bus/line/halfDistance");
			halfDistance.getContent().add(info.getHalfDistance());
			vocElement.getAttributes().add(halfDistance);
		}

		//stop count
		if(info.getAvgRunTime() != 0) {
			AttributeType avgRunTime = new AttributeType();
			avgRunTime.setId("http://epcis.example.com/bus/line/avgRunTime");
			avgRunTime.getContent().add(info.getAvgRunTime());
			vocElement.getAttributes().add(avgRunTime);
		}

		vocElementList.getVocabularyElements().add(vocElement);
		voc.setVocabularyElementList(vocElementList);
	}

	private void stopModeling(BusStopInfoType info) {

		voc.setType("urn:gs1:epcisapp:bus:stop:info");

		VocabularyElementListType vocElementList = new VocabularyElementListType();
		VocabularyElementType vocElement = new VocabularyElementType();
		vocElement.setId("urn:epc:id:gln:" + info.getGln().substring(0, 6) + "." + info.getGln().substring(7));
		
		AttributeType stopid = new AttributeType();
		stopid.setId("http://epcis.example.com/bus/stop/id");
		stopid.getContent().add(info.getStopID());
		vocElement.getAttributes().add(stopid);

		AttributeType number = new AttributeType();
		number.setId("http://epcis.example.com/bus/stop/number");
		number.getContent().add(info.getNumber());
		vocElement.getAttributes().add(number);

		AttributeType name_kr = new AttributeType();
		name_kr.setId("http://epcis.example.com/bus/stop/name_kr");
		name_kr.getContent().add(info.getNameKR());
		vocElement.getAttributes().add(name_kr);
		
		if(info.getNameEN() != null) {
			AttributeType name_en = new AttributeType();
			name_en.setId("http://epcis.example.com/bus/stop/name_en");
			name_en.getContent().add(info.getNameEN());
			vocElement.getAttributes().add(name_en);
		}

		AttributeType gpsX = new AttributeType();
		gpsX.setId("http://epcis.example.com/bus/stop/gpsX");
		gpsX.getContent().add(info.getGpsX());
		vocElement.getAttributes().add(gpsX);

		AttributeType gpsY = new AttributeType();
		gpsY.setId("http://epcis.example.com/bus/stop/gpsY");
		gpsY.getContent().add(info.getGpsY());
		vocElement.getAttributes().add(gpsY);
		
		if(info.getRoad() != null) {
			AttributeType road = new AttributeType();
			road.setId("http://epcis.example.com/bus/stop/road");
			road.getContent().add(info.getRoad());
			vocElement.getAttributes().add(road);
		}
		
		if(info.getAddr() != null) {
			AttributeType addr = new AttributeType();
			addr.setId("http://epcis.example.com/bus/stop/addr");
			addr.getContent().add(info.getAddr());
			vocElement.getAttributes().add(addr);
		}
		
		if(info.getLines() != null) {
			AttributeType lines = new AttributeType();
			lines.setId("http://epcis.example.com/bus/stop/lines");
			lines.getContent().add(info.getLines());
			vocElement.getAttributes().add(lines);
		}

		vocElementList.getVocabularyElements().add(vocElement);
		voc.setVocabularyElementList(vocElementList);
	}

	private void driverModeling(BusDriverInfoType info) {


	}

	private void companyModeling(BusCompanyInfoType info) {


	}


}
