package org.gs1.smartcity.capturing;

import java.io.IOException;
import java.util.Properties;

public abstract class DataManager {
	
	protected static final String PROPERTY_PATH = "smartcity.properties";

	protected static String epcis_ip;
	protected static String epcis_port;
	
	public DataManager() {
		
		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream(PROPERTY_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		epcis_ip = prop.getProperty("epcis_ip");
		epcis_port = prop.getProperty("epcis_port");
	}
	
	public abstract String modeling(String type, Object object);
	
	public abstract int registerEPCIS(String data);

}
