package org.gs1.smartcity.capturing.services;

import java.util.List;

public abstract class UrlGenerator {
	
	public abstract String generate(String serviceType, String infoType, List<String> params);
	
}
