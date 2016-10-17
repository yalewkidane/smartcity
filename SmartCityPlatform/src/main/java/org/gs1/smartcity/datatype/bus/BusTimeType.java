package org.gs1.smartcity.datatype.bus;

public class BusTimeType {

	private String time;
	private String time_sat;
	private String time_sun;
	
	public BusTimeType() {}
	
	public BusTimeType(String time, String time_sat, String time_sun) {
		
		this.time = time;
		this.time_sat = time_sat;
		this.time_sun = time_sun;
	}
	

	public String getTime() {

		return time;
	}

	public void setTime(String value) {

		this.time = value;
	}
	
	public String getTimeSat() {

		return time_sat;
	}

	public void setTimeSat(String value) {

		this.time_sat = value;
	}
	
	public String getTimeSun() {

		return time_sun;
	}

	public void setTimeSun(String value) {

		this.time_sun = value;
	}
	
}
