package org.gs1.smartcity.datatype.bus;

public class BusLineInfoType {

	private String gsrn;
	private String lineid;
	private String number;
	private String busType;
	private String company;
	private BusStopInfoType startPoint;
	private BusStopInfoType endPoint;
	private BusStopInfoType turnPoint;
	private BusTimeType startTime;
	private BusTimeType endTime;
	private BusTimeType turnStartTime;
	private BusTimeType turnEndTime;
	private BusIntervalType interval;
	private int stopCount;
	private String halfDistance;
	private int avgRunTime;


	public BusLineInfoType() {
		
		this.gsrn = null;
		this.lineid = null;
		this.number = null;
		this.busType = null;
		this.company = null;
		this.startPoint = null;
		this.endPoint = null;
		this.turnPoint = null;
		this.startTime = null;
		this.endTime = null;
		this.turnStartTime = null;
		this.turnEndTime = null;
		this.interval = null;
		this.stopCount = 0;
		this.halfDistance = null;
		this.avgRunTime = 0;
	}

	public BusLineInfoType(String gsrn, String lineid, String number, String busType, String company, BusStopInfoType startPoint, BusStopInfoType endPoint,
			BusStopInfoType turnPoint, BusTimeType startTime, BusTimeType endTime, BusTimeType turnStartTime, BusTimeType turnEndTime, BusIntervalType interval,
			int stopCount, String halfDistance, int avgRunTime) {

		this.gsrn = gsrn;
		this.lineid = lineid;
		this.number = number;
		this.busType = busType;
		this.company = company;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.turnPoint = turnPoint;
		this.startTime = startTime;
		this.endTime = endTime;
		this.turnStartTime = turnStartTime;
		this.turnEndTime = turnEndTime;
		this.interval = interval;
		this.stopCount = stopCount;
		this.halfDistance = halfDistance;
		this.avgRunTime = avgRunTime;
	}

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

	public BusStopInfoType getStartPoint() {

		return startPoint;
	}

	public void setStartPoint(BusStopInfoType value) {

		this.startPoint = value;
	}

	public BusStopInfoType getEndPoint() {

		return endPoint;
	}

	public void setEndPoint(BusStopInfoType value) {

		this.endPoint = value;
	}

	public BusStopInfoType getTurnPoint() {

		return turnPoint;
	}

	public void setTurnPoint(BusStopInfoType value) {

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

	public int getStopCount() {

		return stopCount;
	}

	public void setStopCount(int value) {

		this.stopCount = value;
	}

	public String getHalfDistance() {

		return halfDistance;
	}

	public void setHalfDistance(String value) {

		this.halfDistance = value;
	}

	public int getAvgRunTime() {

		return avgRunTime;
	}

	public void setAvgRunTime(int value) {

		this.avgRunTime = value;
	}
}
