package org.gs1.smartcity.datatype.bus;

public class BusIntervalType {

	private String interval;
	private String interval_norm;
	private String interval_peak;
	private String interval_sat;
	private String interval_sun;
	
	public BusIntervalType() {}
	
	public BusIntervalType(String interval, String interval_norm, String interval_peak, String interval_sat, String interval_sun) {
		
		this.interval = interval;
		this.interval_norm = interval_norm;
		this.interval_peak = interval_peak;
		this.interval_sat = interval_sat;
		this.interval_sun = interval_sun;
	}
	

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
