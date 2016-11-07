package org.gs1.smartcity.datatype;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ServiceList")
@XmlAccessorType (XmlAccessType.FIELD)
public class ServiceListType {
	
	@XmlElement(name="Service")
	private List<ServiceType> serviceList;
	
	public List<ServiceType> getServiceList() {
		
		if(serviceList == null) {
			
			serviceList = new ArrayList<ServiceType>();
		}
		return serviceList;
	}
	
	public void serServiceList(List<ServiceType> service) {
		
		this.serviceList = service;
	}

}
