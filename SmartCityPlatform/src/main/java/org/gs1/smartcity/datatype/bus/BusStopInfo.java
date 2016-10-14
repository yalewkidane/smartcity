package org.gs1.smartcity.datatype.bus;

public class BusStopInfo {
	
	private String gln;
	private String number;
	private String name;
	private float gpsX;
	private float gpsY;
	
	public BusStopInfo() {}
	
	public BusStopInfo(String gln, String number, String name, long gpsX, long gpsY) {
		
		this.gln = gln;
		this.number = number;
		this.name = name;
		this.gpsX = gpsX;
		this.gpsY = gpsY;
	}
	
	public String getGln() {
		
		return gln;
	}
	
	public void setGln(String value) {
		
		this.gln = value;
	}
	
	public String getNumber() {
		
		return number;
	}
	
	public void setNumber(String value) {
		
		this.number = value;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String value) {
		
		this.name = value;
	}
	
	public float getGpsX() {
		
		return gpsX;
	}
	
	public void setGpsX(float value) {
		
		this.gpsX = value;
	}
	
	public float getGpsY() {
		
		return gpsY;
	}
	
	public void setGpsY(float value) {
		
		this.gpsY = value;
	}

}
