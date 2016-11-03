package org.gs1.smartcity.capturing.masterdata;

import java.util.Map;

public abstract class MasterDataCollector {
	
	protected MasterDataManager masterDataManager;
	
	public MasterDataCollector(String type) {
		
		masterDataManager = (new MasterDataManagerFactory()).getManager(type);
	}
	
	public abstract void collect(Map<String, String> map);

}
