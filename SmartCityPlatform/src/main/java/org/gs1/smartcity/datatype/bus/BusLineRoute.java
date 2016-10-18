package org.gs1.smartcity.datatype.bus;

public class BusLineRoute {

	private String gsrn;
	private BusStopList stopList;
	
	public BusLineRoute() {
		
		stopList = new BusStopList();
	}
	
	public String getGsrn() {
		
		return gsrn;
	}
	
	public void setGsrn(String value) {
		
		this.gsrn = value;
	}
	
	public BusStopList getStopList() {
		
		return stopList;
	}
	
	public void setStopList(BusStopList value) {
		
		this.stopList = value;
	}
	
	public void addStopList(BusRouteStopInfo value) {
		
		this.stopList.add(value);
	}
	
}
