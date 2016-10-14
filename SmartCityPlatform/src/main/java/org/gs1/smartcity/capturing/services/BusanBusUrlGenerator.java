package org.gs1.smartcity.capturing.services;

public class BusanBusUrlGenerator extends UrlGenerator {
	
	private static final String SERVICE_KEY = "R8RJ0f8P4axgqFrzLWCgOQVB0DBfv%2BAuage21m1EbHL9EbuCQWt87UrjsC0KudLI3had%2BceHCcuFSab5hq5Iew%3D%3D";
	
	public String generate(String type, String parm1, String parm2) {
		
		String url = "http://61.43.246.153/openapi-data/service/busanBIMS/";
		
		if(type.compareTo(BusInfoFactory.BUSAN_BUS_LINE_INFO) == 0) {
			url = url + type + "?lineid=" + parm1;
		} else if(type.compareTo(BusInfoFactory.BUSAN_BUS_STOP_ARR) == 0) {
			url = url + type + "?bstopid=" + parm1 + "&lineid=" + parm2;
		}
		
		url = url + "&serviceKey=" + SERVICE_KEY;
		
		return url;
	}

}