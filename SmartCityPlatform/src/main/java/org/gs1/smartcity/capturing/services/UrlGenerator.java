package org.gs1.smartcity.capturing.services;

import java.util.List;

public abstract class UrlGenerator {
	
	public abstract String generate(String serviceName, String serviceType, List<String> params);
	
}
