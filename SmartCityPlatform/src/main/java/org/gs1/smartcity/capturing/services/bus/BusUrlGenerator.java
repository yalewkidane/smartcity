package org.gs1.smartcity.capturing.services.bus;

import java.util.List;

import org.gs1.smartcity.capturing.services.ServiceFactory;
import org.gs1.smartcity.capturing.services.UrlGenerator;

public class BusUrlGenerator extends UrlGenerator {

	private static final String BUSAN_SERVICE_KEY = "R8RJ0f8P4axgqFrzLWCgOQVB0DBfv%2BAuage21m1EbHL9EbuCQWt87UrjsC0KudLI3had%2BceHCcuFSab5hq5Iew%3D%3D";
	private static final String DAEJEON_SERVICE_KEY = "R8RJ0f8P4axgqFrzLWCgOQVB0DBfv%2BAuage21m1EbHL9EbuCQWt87UrjsC0KudLI3had%2BceHCcuFSab5hq5Iew%3D%3D";

	public String generate(String serviceType, String infoType, List<String> params) {

		String url = null;

		if(serviceType.equals(ServiceFactory.BUSAN_BUS)) {
			url = "http://61.43.246.153/openapi-data/service/busanBIMS/";

			if(infoType.compareTo(BusServiceFactory.BUS_LINE_INFO) == 0) {
				url = url + "busInfo?lineid=" + params.get(0) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_STOP_INFO) == 0) {
				url = url + "busStop?arsno=" + params.get(0) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_LINE_ROUTE) == 0) {
				url = url + "busInfoRoute?lineid=" + params.get(0) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_STOP_ARR) == 0) {
				url = url + "stopArr?bstopid=" + params.get(0) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_LINE_STOP_ARR) == 0) {
				url = url + "busStopArr?bstopid=" + params.get(0) + "&lineid=" + params.get(1) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_LINE_INFO_ALL) == 0) {
				url = url + "busInfo?";
			} else if(infoType.compareTo(BusServiceFactory.BUS_STOP_INFO_ALL) == 0) {
				url = url + "busStop?";
			}

			url = url + "serviceKey=" + BUSAN_SERVICE_KEY;
		} else if(serviceType.equals(ServiceFactory.DAEJEON_BUS)) {
			url = "http://openapitraffic.daejeon.go.kr/api/rest/";

			if(infoType.compareTo(BusServiceFactory.BUS_LINE_ROUTE) == 0) {
				url = url + "busRouteInfo/getStaionByRoute?busRouteId=" + params.get(0) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_LINE_ROUTE_ALL) == 0) {
				url = url + "busRouteInfo/getStaionByRouteAll?";
			} else if(infoType.compareTo(BusServiceFactory.BUS_LINE_INFO) == 0) {
				url = url + "busRouteInfo/getRouteInfo?busRouteId=" + params.get(0) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_LINE_INFO_ALL) == 0) {
				url = url + "busRouteInfo/getRouteInfoAll?serviceKey=" + DAEJEON_SERVICE_KEY + "&reqPage=" + params.get(0);
				return url;
			} else if(infoType.compareTo(BusServiceFactory.BUS_STOP_INFO) == 0) {
				if(params.get(0).length() == 7) {
					url = url + "stationinfo/getStationByStopID?busStopID=" + params.get(0) + "&";
				} else if(params.get(0).length() == 5) {
					url = url + "stationinfo/getStationByUid?arsId=" + params.get(0) + "&";
				}
			} else if(infoType.compareTo(BusServiceFactory.BUS_LINE_POS) == 0) {
				url = url + "busposinfo/getBusPosByRtid?busRouteId=" + params.get(0) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_STOP_ARR) == 0) {
				if(params.get(0).length() == 7) {
					url = url + "arrive/getArrInfoByStopID?busStopID=" + params.get(0) + "&";
				} else if(params.get(0).length() == 5) {
					url = url + "arrive/getArrInfoByUid?arsId=" + params.get(0) + "&";
				}
			} else if(infoType.compareTo(BusServiceFactory.BUS_REG_INFO_ALL) == 0) {
				url = url + "busreginfo/getBusRegInfoAll?";
			} else if(infoType.compareTo(BusServiceFactory.BUS_REG_INFO) == 0) {
				url = url + "busreginfo/getBusRegInfoByRouteId?busRouteId=" + params.get(0) + "&";
			} else if(infoType.compareTo(BusServiceFactory.BUS_COMPANY_INFO) == 0) {
				url = url + "buscompinfo/getBusCompInfo?serviceKey=" + DAEJEON_SERVICE_KEY + "&reqPage=" + params.get(0);
				return url;
			}

			url = url + "serviceKey=" + DAEJEON_SERVICE_KEY;
		}

		return url;
	}
}