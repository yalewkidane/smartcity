package org.gs1.smartcity.datatype.bus;

public class BusPosInfoType {
	
	private String giai;
	private String lineid;
	private int direction;
	private BusStopInfoType stop;
	
	public String getGiai() {
		
		return giai;
	}
	
	public void setGiai(String value) {
		
		this.giai = value;
	}
	
	public String getLineID() {
		
		return lineid;
	}
	
	public void setLineID(String value) {
		 
		this.lineid = value;
	}
	
	public int getDirection() {
		
		return direction;
	}
	
	public void setDirection(int value) {
		
		this.direction = value;
	}
	
	public BusStopInfoType getStop() {
		
		return stop;
	}
	
	public void setStop(BusStopInfoType value) {
		
		this.stop = value;
	}

}
