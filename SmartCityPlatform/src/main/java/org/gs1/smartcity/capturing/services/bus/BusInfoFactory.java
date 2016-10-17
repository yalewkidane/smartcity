package org.gs1.smartcity.capturing.services.bus;

public class BusInfoFactory {
	
	//bus master data information
	public static final String BUS_LINE_INFO = "busInfo";
	public static final String BUS_STOP_INFO = "busStopInfo";
	public static final String BUS_DRIVER_INFO = "busDriverInfo";
	public static final String BUS_COMPANY_INFO = "busCompanyInfo";
	
	//busan bus information
	public static final String BUSAN_BUS_LINE_INFO = "busInfo";			//버스 노선 정보
	public static final String BUSAN_BUS_STOP_INFO = "busStop";			//버스 정류소 정보
	public static final String BUSAN_BUS_LINE_ROUTE = "busInfoRoute";	//버스 노선의 정류소 정보 및 실시간 버스 위치 정보
	public static final String BUSAN_BUS_STOP_ARR = "stopArr";			//버스 정류소 버스 도착 정보
	public static final String BUSAN_BUS_LINE_STOP = "busStopArr";		//버스 노선-정류소 도착 정보
	public static final String BUSAN_BUS_LINE_ALL = "busInfo";
	public static final String BUSAN_BUS_STOP_ALL = "busStop";

	//daejeon bus information
	public static final String DAEJEON_BUS_LINE_ROUTE = "busRouteInfo/getStationByRoute";			//버스 노선의 정류소 정보
	public static final String DAEJEON_BUS_LINE_ROUTE_ALL = "busRouteInfo/getStationByRouteAll";	//모든 버스 노선의 정류소 정보
	public static final String DAEJEON_BUS_LINE_INFO = "busRouteInfo/getRouteInfo";					//버스 노선 정보
	public static final String DAEJEON_BUS_LINE_INFO_ALL = "busRouteInfo/getRouteInfoAll";			//모든 버스 노선 정보
	public static final String DAEJEON_BUS_STOP_INFO = "stationinfo/getStationBy";					//버스 정류소 정보
	public static final String DAEJEON_BUS_LINE_POS = "busposinfo/getBusPosByRtid";					//노선별 버스 위치 정보
	public static final String DAEJEON_BUS_STOP_ARR = "arrive/getArrInfoBy";						//버스 정류소 버스 도착 정보
	public static final String DAEJEON_BUS_REG_INFO_ALL = "busreginfo/getBusRegInfoAll";			//전체 버스 등록 차량 정보
	public static final String DAEJEON_BUS_REG_INFO = "busreginfo/getBusRegInfoByRouteId";			//노선별 등록 차량 정보
	public static final String DAEJEON_BUS_COMPANY_INFO = "buscompinfo/getBusCompInfo";				//버스 회사 정보
	
}
