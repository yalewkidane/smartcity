package org.gs1.smartcity.capturing.services;

public abstract class UrlGenerator {
	
	protected String serviceType;
	
	public abstract String generate(String infoType, String parm1, String parm2);

}
