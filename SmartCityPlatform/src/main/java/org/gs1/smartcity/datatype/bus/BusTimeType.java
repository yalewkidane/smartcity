package org.gs1.smartcity.datatype.bus;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusTimeType {

	private String time;
	private String time_sat;
	private String time_sun;

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
