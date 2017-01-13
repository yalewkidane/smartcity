package org.gs1.smartcity.datatype;

import java.util.ArrayList;
import java.util.List;

public class MatchingSchemeType {
	
	private String serviceName;
	private String infoType;
	private List<SchemeValueType> schemeList;
	
	public String getServiceName() {
		
		return serviceName;
	}
	
	public void setServiceName(String value) {
		
		this.serviceName = value;
	}
	
	public String getInfoType() {
		
		return infoType;
	}
	
	public void setInfoType(String value) {
		
		this.infoType = value;
	}
	
	public List<SchemeValueType> getSchemeList() {
		
		if(schemeList == null) {
			schemeList = new ArrayList<SchemeValueType>();
		}
		return schemeList;
	}

}
