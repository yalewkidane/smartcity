package org.gs1.smartcity.capturing.masterdata.bus;

import java.util.Map;

import org.gs1.smartcity.capturing.ServiceFactory;
import org.gs1.smartcity.capturing.masterdata.MasterDataCollector;

public class BusMasterDataCollector extends MasterDataCollector {
	
	public BusMasterDataCollector() {
		
		super(ServiceFactory.BUS);
	}
	
	public void collect(Map<String, String> map) {
		
		
	}

}
