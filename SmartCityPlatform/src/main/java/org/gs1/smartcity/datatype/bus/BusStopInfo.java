package org.gs1.smartcity.datatype.bus;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusStopInfo {

	private String gln;
	private String stopid;
	private String number;
	private String name_kr;
	private String name_en;
	private String gpsX;
	private String gpsY;
	private String road;
	private String addr;
	private String lines;

	public String getGln() {

		return gln;
	}

	public void setGln(String value) {

		this.gln = value;
	}

	public String getStopID() {

		return stopid;
	}

	public void setStopID(String value) {

		this.stopid = value;
	}

	public String getNumber() {

		return number;
	}

	public void setNumber(String value) {

		this.number = value;
	}

	public String getNameKR() {

		return name_kr;
	}

	public void setNameKR(String value) {

		this.name_kr = value;
	}
	
	public String getNameEN() {

		return name_en;
	}

	public void setNameEN(String value) {

		this.name_en = value;
	}

	public String getGpsX() {

		return gpsX;
	}

	public void setGpsX(String value) {

		this.gpsX = value;
	}

	public String getGpsY() {

		return gpsY;
	}

	public void setGpsY(String value) {

		this.gpsY = value;
	}
	
	public String getRoad() {

		return road;
	}

	public void setRoad(String value) {

		this.road = value;
	}
	
	public String getAddr() {

		return addr;
	}

	public void setAddr(String value) {

		this.addr = value;
	}
	
	public String getLines() {

		return lines;
	}

	public void setLines(String value) {

		this.lines = value;
	}

}
