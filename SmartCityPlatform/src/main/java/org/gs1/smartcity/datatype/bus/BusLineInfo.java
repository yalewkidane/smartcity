package org.gs1.smartcity.datatype.bus;

public class BusLineInfo {

	private String gsrn;
	private String number;
	private String busType;
	private String company;
	private String startPoint;
	private String endPoint;
	private String startTime;
	private String endTime;
	private int interval;
	
	public BusLineInfo() {}
	
	public BusLineInfo(String gsrn, String number, String busType, String company, String startPoint, String endPoint, String startTime, String endTime, int interval) {
		
		this.gsrn = gsrn;
		this.number = number;
		this.busType = busType;
		this.company = company;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.startTime = startTime;
		this.endTime = endTime;
		this.interval = interval;
	}

	public String getGsrn() {

		return gsrn;
	}

	public void setGsrn(String value) {

		this.gsrn = value;
	}

	public String getNumber() {

		return number;
	}

	public void setNumber(String value) {

		this.number = value;
	}

	public String getBusType() {

		return busType;
	}

	public void setBusType(String value) {

		this.busType = value;
	}

	public String getCompany() {

		return company;
	}

	public void setCompany(String value) {

		this.company = value;
	}

	public String getStartPoint() {

		return startPoint;
	}

	public void setStartPoint(String value) {

		this.startPoint = value;
	}

	public String getEndPoint() {

		return endPoint;
	}

	public void setEndPoint(String value) {

		this.endPoint = value;
	}

	public String getStartTime() {

		return startTime;
	}

	public void setStartTime(String value) {

		this.startTime = value;
	}

	public String getEndTime() {

		return endTime;
	}

	public void setEndTime(String value) {

		this.endTime = value;
	}

	public int getInterval() {

		return interval;
	}

	public void setInterval(int value) {

		this.interval = value;
	}

}
