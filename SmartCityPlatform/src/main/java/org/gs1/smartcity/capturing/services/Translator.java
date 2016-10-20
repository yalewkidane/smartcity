package org.gs1.smartcity.capturing.services;

public abstract class Translator {
	
	public abstract Object translate(String serviceType, String infoType, String data);

}
