package org.gs1.smartcity.capturing.services.bus;

import org.gs1.smartcity.capturing.services.ServiceFactory;
import org.gs1.smartcity.capturing.services.UrlGenerator;

public class BusUrlGenerator extends UrlGenerator {

	private static final String BUSAN_SERVICE_KEY = "R8RJ0f8P4axgqFrzLWCgOQVB0DBfv%2BAuage21m1EbHL9EbuCQWt87UrjsC0KudLI3had%2BceHCcuFSab5hq5Iew%3D%3D";
	private static final String DAEJEON_SERVICE_KEY = "R8RJ0f8P4axgqFrzLWCgOQVB0DBfv%2BAuage21m1EbHL9EbuCQWt87UrjsC0KudLI3had%2BceHCcuFSab5hq5Iew%3D%3D";

	public BusUrlGenerator(String serviceType) {
		this.serviceType = serviceType;
	}

	public String generate(String infoType, String parm1, String parm2) {

		if (serviceType.compareTo(ServiceFactory.BUSAN_BUS) == 0) {
			return generateBusan(infoType, parm1, parm2);
		} else if (serviceType.compareTo(ServiceFactory.DAEJEON_BUS) == 0) {
			return generateDaejeon(infoType, parm1);
		}

		return null;
	}

	public String generateBusan(String infoType, String parm1, String parm2) {

		String url = "http://61.43.246.153/openapi-data/service/busanBIMS/";

		if(infoType.compareTo(BusServiceFactory.BUSAN_BUS_LINE_INFO) == 0) {
			url = url + infoType + "?lineid=" + parm1 + "&";
		} else if(infoType.compareTo(BusServiceFactory.BUSAN_BUS_STOP_INFO) == 0) {
			url = url + infoType + "?arsno=" + parm1 + "&";
		} else if(infoType.compareTo(BusServiceFactory.BUSAN_BUS_LINE_ROUTE) == 0) {
			url = url + infoType + "?lineid=" + parm1 + "&";
		} else if(infoType.compareTo(BusServiceFactory.BUSAN_BUS_STOP_ARR) == 0) {
			url = url + infoType + "?bstopid=" + parm1 + "&";
		} else if(infoType.compareTo(BusServiceFactory.BUSAN_BUS_LINE_STOP) == 0) {
			url = url + infoType + "?bstopid=" + parm1 + "&lineid=" + parm2 + "&";
		} else if(infoType.compareTo(BusServiceFactory.BUSAN_BUS_LINE_INFO_ALL) == 0) {
			url = url + infoType.substring(0, 7) + "?";
		} else if(infoType.compareTo(BusServiceFactory.BUSAN_BUS_STOP_INFO_ALL) == 0) {
			url = url + infoType + "?";
		}

		url = url + "serviceKey=" + BUSAN_SERVICE_KEY;

		return url;
	}

	public String generateDaejeon(String infoType, String parm) {

		String url = "http://openapitraffic.daejeon.go.kr/api/rest/";

		if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_ROUTE) == 0) {
			url = url + infoType + "?busRouteId=" + parm + "&";
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_ROUTE_ALL) == 0) {
			url = url + infoType + "?";
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_INFO) == 0) {
			url = url + infoType + "?busRouteId=" + parm + "&";
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_INFO_ALL) == 0) {
			url = url + infoType + "?serviceKey=" + DAEJEON_SERVICE_KEY + "&reqPage=" + parm;
			return url;
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_STOP_INFO) == 0) {
			if(parm.length() == 7) {
				url = url + infoType + "StopID?busStopID=" + parm + "&";
			} else if(parm.length() == 5) {
				url = url + infoType + "Uid?arsId=" + parm + "&";
			}
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_LINE_POS) == 0) {
			url = url + infoType + "?busRouteId=" + parm + "&";
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_STOP_ARR) == 0) {
			if(parm.length() == 7) {
				url = url + infoType + "StopID?busStopID=" + parm + "&";
			} else if(parm.length() == 5) {
				url = url + infoType + "Uid?arsId=" + parm + "&";
			}
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_REG_INFO_ALL) == 0) {
			url = url + infoType + "?";
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_REG_INFO) == 0) {
			url = url + infoType + "?busRouteId=" + parm + "&";
		} else if(infoType.compareTo(BusServiceFactory.DAEJEON_BUS_COMPANY_INFO) == 0) {
			url = url + infoType + "?";
		}

		url = url + "serviceKey=" + DAEJEON_SERVICE_KEY;

		return url;
	}


}