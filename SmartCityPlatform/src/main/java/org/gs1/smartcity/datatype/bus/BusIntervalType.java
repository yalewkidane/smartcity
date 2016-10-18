package org.gs1.smartcity.datatype.bus;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusIntervalType {

	private String interval;
	private String interval_norm;
	private String interval_peak;
	private String interval_sat;
	private String interval_sun;

	public String getInterval() {

		return interval;
	}

	public void setInterval(String value) {

		this.interval = value;
	}
	
	public String getIntervalNorm() {

		return interval_norm;
	}

	public void setIntervalNorm(String value) {

		this.interval_norm = value;
	}
	
	public String getIntervalPeak() {

		return interval_peak;
	}

	public void setIntervalPeak(String value) {

		this.interval_peak = value;
	}
	
	public String getIntervalSat() {

		return interval_sat;
	}

	public void setIntervalSat(String value) {

		this.interval_sat = value;
	}
	
	public String getIntervalSun() {

		return interval_sun;
	}

	public void setIntervalSun(String value) {

		this.interval_sun = value;
	}
}
