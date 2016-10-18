package org.gs1.smartcity.datatype.bus;

public class BusLineInfo {

	private String gsrn;
	private String lineid;
	private String number;
	private String busType;
	private String company;
	private BusStopInfo startPoint;
	private BusStopInfo endPoint;
	private BusStopInfo turnPoint;
	private BusTimeType startTime;
	private BusTimeType endTime;
	private BusTimeType turnStartTime;
	private BusTimeType turnEndTime;
	private BusIntervalType interval;
	private String stopCount;
	private String halfDistance;
	private String avgRunTime;

	public String getGsrn() {

		return gsrn;
	}

	public void setGsrn(String value) {

		this.gsrn = value;
	}

	public String getLineID() {

		return lineid;
	}

	public void setLineID(String value) {

		this.lineid = value;
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

	public BusStopInfo getStartPoint() {

		return startPoint;
	}

	public void setStartPoint(BusStopInfo value) {

		this.startPoint = value;
	}

	public BusStopInfo getEndPoint() {

		return endPoint;
	}

	public void setEndPoint(BusStopInfo value) {

		this.endPoint = value;
	}

	public BusStopInfo getTurnPoint() {

		return turnPoint;
	}

	public void setTurnPoint(BusStopInfo value) {

		this.turnPoint = value;
	}

	public BusTimeType getStartTime() {

		return startTime;
	}

	public void setStartTime(BusTimeType value) {

		this.startTime = value;
	}

	public BusTimeType getEndTime() {

		return endTime;
	}

	public void setEndTime(BusTimeType value) {

		this.endTime = value;
	}

	public BusTimeType getTurnStartTime() {

		return turnStartTime;
	}

	public void setTurnStartTime(BusTimeType value) {

		this.turnStartTime = value;
	}

	public BusTimeType getTurnEndTime() {

		return turnEndTime;
	}

	public void setTurnEndTime(BusTimeType value) {

		this.turnEndTime = value;
	}

	public BusIntervalType getInterval() {

		return interval;
	}

	public void setInterval(BusIntervalType value) {

		this.interval = value;
	}

	public String getStopCount() {

		return stopCount;
	}

	public void setStopCount(String value) {

		this.stopCount = value;
	}

	public String getHalfDistance() {

		return halfDistance;
	}

	public void setHalfDistance(String value) {

		this.halfDistance = value;
	}

	public String getAvgRunTime() {

		return avgRunTime;
	}

	public void setAvgRunTime(String value) {

		this.avgRunTime = value;
	}
}
