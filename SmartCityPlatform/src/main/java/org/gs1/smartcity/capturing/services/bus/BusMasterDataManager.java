package org.gs1.smartcity.capturing.services.bus;

import java.util.List;

import org.gs1.epcglobal.epcis.AttributeType;
import org.gs1.epcglobal.epcis.VocabularyElementListType;
import org.gs1.epcglobal.epcis.VocabularyElementType;
import org.gs1.smartcity.capturing.masterdata.MasterDataManager;
import org.gs1.smartcity.datatype.bus.BusCompanyInfoType;
import org.gs1.smartcity.datatype.bus.BusDriverInfoType;
import org.gs1.smartcity.datatype.bus.BusLineInfoType;
import org.gs1.smartcity.datatype.bus.BusLineRouteType;
import org.gs1.smartcity.datatype.bus.BusVehicleInfoType;
import org.gs1.smartcity.datatype.bus.master.BusStopInfoType;

public class BusMasterDataManager extends MasterDataManager {

	@SuppressWarnings("unchecked")
	public String modeling(String type, Object object) {
		
		String result = null;

		if (type.equals(BusServiceFactory.BUS_LINE_INFO)) {
			lineModeling((List<BusLineInfoType>) object);
		} else if (type.equals(BusServiceFactory.BUS_STOP_INFO)) {
			stopModeling((List<BusStopInfoType>) object);
		} else if (type.equals(BusServiceFactory.BUS_DRIVER_INFO)) {
			driverModeling((BusDriverInfoType) object);
		} else if (type.equals(BusServiceFactory.BUS_COMPANY_INFO)) {
			companyModeling((List<BusCompanyInfoType>) object);
		} else if (type.equals(BusServiceFactory.BUS_LINE_ROUTE)) {
			lineRouteModeling((BusLineRouteType) object);
		} else if (type.equals(BusServiceFactory.BUS_VEHICLE_INFO)) {
			vehicleModeling((List<BusVehicleInfoType>) object);
		}
		
		headerModeling();
		marshaller.make(sbdh, voc);
		result = marshaller.marshal();

		return result;
	}

	private void lineModeling(List<BusLineInfoType> infoList) {

		voc.setType("urn:gs1:epcisapp:bus:line:info");
		VocabularyElementListType vocElementList = new VocabularyElementListType();

		for(int i = 0; i < infoList.size(); i++) {
			BusLineInfoType info = infoList.get(i);
			VocabularyElementType vocElement = new VocabularyElementType();
			vocElement.setId("urn:epc:id:gsrn:" + info.getGsrn().substring(0, 7) + "." + info.getGsrn().substring(7));

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
			if(info.getCompany() != null) {
				AttributeType company = new AttributeType();
				company.setId("http://epcis.example.com/bus/line/company");
				company.getContent().add(info.getCompany());
				vocElement.getAttributes().add(company);
			}

			//start point
			AttributeType startPoint = new AttributeType();
			startPoint.setId("http://epcis.example.com/bus/line/startPoint");
			startPoint.getContent().add(info.getStartPoint());

			vocElement.getAttributes().add(startPoint);

			//end point
			AttributeType endPoint = new AttributeType();
			endPoint.setId("http://epcis.example.com/bus/line/endPoint");
			endPoint.getContent().add(info.getEndPoint());

			vocElement.getAttributes().add(endPoint);

			//turn point
			if(info.getTurnPoint() != null) {
				AttributeType turnPoint = new AttributeType();
				turnPoint.setId("http://epcis.example.com/bus/line/turnPoint");
				turnPoint.getContent().add(info.getTurnPoint());

				vocElement.getAttributes().add(turnPoint);
			}

			//start time
			AttributeType startTime = new AttributeType();
			startTime.setId("http://epcis.example.com/bus/line/startTime");
			startTime.getContent().add(info.getStartTime());

			vocElement.getAttributes().add(startTime);

			//end time
			AttributeType endTime = new AttributeType();
			endTime.setId("http://epcis.example.com/bus/line/endTime");
			endTime.getContent().add(info.getEndTime());

			vocElement.getAttributes().add(endTime);

			//turn start time
			if(info.getTurnStartTime() != null) {
				AttributeType turnStartTime = new AttributeType();
				turnStartTime.setId("http://epcis.example.com/bus/line/turnStartTime");
				turnStartTime.getContent().add(info.getTurnStartTime());


				vocElement.getAttributes().add(turnStartTime);
			}

			//turn end time
			if(info.getTurnEndTime() != null) {
				AttributeType turnEndTime = new AttributeType();
				turnEndTime.setId("http://epcis.example.com/bus/line/endTime");
				turnEndTime.getContent().add(info.getTurnEndTime());

				vocElement.getAttributes().add(turnEndTime);
			}

			//interval
			if(info.getInterval() != null) {
				AttributeType interval = new AttributeType();
				interval.setId("http://epcis.example.com/bus/line/interval");
				interval.getContent().add(info.getInterval());
				vocElement.getAttributes().add(interval);
			}

			//stop count
			if(info.getStopCount() != null) {
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
			if(info.getAvgRunTime() != null) {
				AttributeType avgRunTime = new AttributeType();
				avgRunTime.setId("http://epcis.example.com/bus/line/avgRunTime");
				avgRunTime.getContent().add(info.getAvgRunTime());
				vocElement.getAttributes().add(avgRunTime);
			}

			vocElementList.getVocabularyElements().add(vocElement);
		}

		voc.setVocabularyElementList(vocElementList);
	}

	private void stopModeling(List<BusStopInfoType> infoList) {

		voc.setType("urn:gs1:epcisapp:bus:stop:info");
		VocabularyElementListType vocElementList = new VocabularyElementListType();

		for(int i = 0; i < infoList.size(); i++) {
			BusStopInfoType info = infoList.get(i);

			VocabularyElementType vocElement = new VocabularyElementType();
			vocElement.setId("urn:epc:id:gln:" + info.getGln().substring(0, 7) + "." + info.getGln().substring(7));

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
		}

		voc.setVocabularyElementList(vocElementList);
	}

	private void driverModeling(BusDriverInfoType info) {

	}

	private void companyModeling(List<BusCompanyInfoType> infoList) {

		voc.setType("urn:gs1:epcisapp:bus:company:info");
		VocabularyElementListType vocElementList = new VocabularyElementListType();

		for(int i = 0; i < infoList.size(); i++) {
			BusCompanyInfoType info = infoList.get(i);
			VocabularyElementType vocElement = new VocabularyElementType();
			vocElement.setId("urn:epc:id:gln:" + info.getGln().substring(0, 7) + "." + info.getGln().substring(7));

			AttributeType companyid = new AttributeType();
			companyid.setId("http://epcis.example.com/bus/company/id");
			companyid.getContent().add(info.getCompanyID());
			vocElement.getAttributes().add(companyid);

			AttributeType name = new AttributeType();
			name.setId("http://epcis.example.com/bus/company/name");
			name.getContent().add(info.getName());
			vocElement.getAttributes().add(name);

			AttributeType addr = new AttributeType();
			addr.setId("http://epcis.example.com/bus/company/address");
			addr.getContent().add(info.getAddr());
			vocElement.getAttributes().add(addr);

			AttributeType tel = new AttributeType();
			tel.setId("http://epcis.example.com/bus/company/tel_number");
			tel.getContent().add(info.getTel());
			vocElement.getAttributes().add(tel);

			vocElementList.getVocabularyElements().add(vocElement);
		}

		voc.setVocabularyElementList(vocElementList);
	}

	private void lineRouteModeling(BusLineRouteType info) {

		voc.setType("urn:gs1:epcisapp:bus:line:route");
		VocabularyElementListType vocElementList = new VocabularyElementListType();

		VocabularyElementType vocElement = new VocabularyElementType();
		vocElement.setId("urn:epc:id:gsrn:" + info.getGsrn().substring(0, 7) + "." + info.getGsrn().substring(7));

		AttributeType stopList = new AttributeType();
		stopList.setId("http://epcis.example.com/bus/line/route/stop_list");
		stopList.getContent().add(info.getStopList());

		vocElement.getAttributes().add(stopList);

		vocElementList.getVocabularyElements().add(vocElement);

		voc.setVocabularyElementList(vocElementList);
	}

	private void vehicleModeling(List<BusVehicleInfoType> infoList) {

		voc.setType("urn:gs1:epcisapp:bus:vehicle:info");
		VocabularyElementListType vocElementList = new VocabularyElementListType();

		for(int i = 0; i < infoList.size(); i++) {
			BusVehicleInfoType info = infoList.get(i);
			VocabularyElementType vocElement = new VocabularyElementType();
			vocElement.setId("urn:epc:id:giai:" + info.getGiai().substring(0, 7) + "." + info.getGiai().substring(7));

			AttributeType number = new AttributeType();
			number.setId("http://epcis.example.com/bus/vehicle/number");
			number.getContent().add(info.getNumber());
			vocElement.getAttributes().add(number);

			AttributeType busLine = new AttributeType();
			busLine.setId("http://epcis.example.com/bus/company/busLine");
			busLine.getContent().add(info.getBusLine());
			vocElement.getAttributes().add(busLine);

			vocElementList.getVocabularyElements().add(vocElement);
		}

		voc.setVocabularyElementList(vocElementList);
	}

}
