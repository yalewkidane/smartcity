package org.gs1.smartcity.datatype.url;

public class ServiceUrlDetailType {

	private String serviceName;
	private String infoType;
	private String infoUrl;
	private int numOfParams;

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

	public String getInfoUrl() {

		return infoUrl; 
	}

	public void setInfoUrl(String value) {

		this.infoUrl = value;
	}

	public int getNumOfParams() {

		return numOfParams;
	}

	public void setNumOfParams(int value) {

		this.numOfParams = value;
	}

}
