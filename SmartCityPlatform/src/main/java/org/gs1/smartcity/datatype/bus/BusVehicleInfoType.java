package org.gs1.smartcity.datatype.bus;

public class BusVehicleInfoType {
	
	private String giai;
	private String number;
	private String busLine;	//epc of bus line
	
	public String getGiai() {
		
		return giai;
	}
	
	public void setGiai(String value) {
		
		this.giai = value;
	}
	
	public String getNumber() {
		
		return number;
	}
	
	public void setNumber(String value) {
		
		this.number = value;
	}
	
	public String getBusLine() {
		
		return busLine;
	}
	
	public void setBusLine(String value) {
		
		this.busLine = value;
	}

}
