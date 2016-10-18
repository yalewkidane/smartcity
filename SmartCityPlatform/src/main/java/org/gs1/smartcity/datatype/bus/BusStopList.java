package org.gs1.smartcity.datatype.bus;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusStopList {
	
	private List<BusRouteStopInfo> list;
	
	public List<BusRouteStopInfo> getBusRouteStopInfoList() {
		
		return list;
	}
	
	@XmlElement(name="BusStop")
	public void setBusRouteStopInfoList(List<BusRouteStopInfo> value) {
		
		this.list = value;
	}
	
	public void add(BusRouteStopInfo value) {
		
		if(this.list == null) {
			this.list = new ArrayList<BusRouteStopInfo>();
		}
		
		this.list.add(value);
	}

}
