package org.gs1.smartcity.capturing.services;

import org.gs1.smartcity.datatype.bus.BusLineInfo;
import org.gs1.smartcity.datatype.bus.BusStopInfo;

public class BusanBusTranslator extends Translator {

	public void translate(String type, String data)  {
		
		if (type.compareTo(BusInfoFactory.BUSAN_BUS_LINE_INFO) == 0) {
			busLineInformation(data);
		} else if (type.compareTo(BusInfoFactory.BUSAN_BUS_STOP) == 0) {
			busStopInformation(data);
		} else if (type.compareTo(BusInfoFactory.BUSAN_BUS_LINE_ROUTE) == 0) {
			
		} else if (type.compareTo(BusInfoFactory.BUSAN_BUS_STOP_ARR) == 0) {
			
		} else if (type.compareTo(BusInfoFactory.BUSAN_BUS_LINE_STOP) == 0) {
			
		} else {}
		
	}
	
	private void busLineInformation(String data) {
		
		BusLineInfo info = new BusLineInfo();
		
		info.setGsrn("");
		info.setNumber(data.substring(data.lastIndexOf("<buslinenum>") + "<buslinenum>".length(), data.lastIndexOf("</buslinenum>")));
		info.setBusType(data.substring(data.lastIndexOf("<bustype>") + "<bustype>".length(), data.lastIndexOf("</bustype>")));
		info.setCompany(data.substring(data.lastIndexOf("<companyid>") + "<companyid>".length(), data.lastIndexOf("</companyid>")));
		info.setStartPoint(data.substring(data.lastIndexOf("<startpoint>") + "<startpoint>".length(), data.lastIndexOf("</startpoint>")));
		info.setEndPoint(data.substring(data.lastIndexOf("<endpoint>") + "<endpoint>".length(), data.lastIndexOf("</endpoint>")));
		info.setStartTime(data.substring(data.lastIndexOf("<firsttime>") + "<firsttime>".length(), data.lastIndexOf("</firsttime>")));
		info.setEndTime(data.substring(data.lastIndexOf("<endtime>") + "<endtime>".length(), data.lastIndexOf("</endtime>")));
		
	}
	
	private void busStopInformation(String data) {
		
		BusStopInfo info = new BusStopInfo();
		
		info.setGln("");
		info.setNumber(data.substring(data.lastIndexOf("<bstopArsno>") + "<bstopArsno>".length(), data.lastIndexOf("</bstopArsno>")));
		info.setName(data.substring(data.lastIndexOf("<bstopNm>") + "<bstopNm>".length(), data.lastIndexOf("</bstopNm>")));
		info.setGpsX(Float.parseFloat(data.substring(data.lastIndexOf("<gpsX>") + "<gpsX>".length(), data.lastIndexOf("</gpsX>"))));
		info.setGpsY(Float.parseFloat(data.substring(data.lastIndexOf("<gpsY>") + "<gpsY>".length(), data.lastIndexOf("</gpsY>"))));
		
	}

}
