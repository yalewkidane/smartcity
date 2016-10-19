package org.gs1.smartcity.datatype.bus;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusStopListType {
	
	private List<BusRouteStopInfoType> list;
	
	public List<BusRouteStopInfoType> getBusRouteStopInfoList() {
		
		return list;
	}
	
	@XmlElement(name="BusStop")
	public void setBusRouteStopInfoList(List<BusRouteStopInfoType> value) {
		
		this.list = value;
	}
	
	public void add(BusRouteStopInfoType value) {
		
		if(this.list == null) {
			this.list = new ArrayList<BusRouteStopInfoType>();
		}
		
		this.list.add(value);
	}

}
