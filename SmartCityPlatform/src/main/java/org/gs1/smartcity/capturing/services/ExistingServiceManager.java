package org.gs1.smartcity.capturing.services;

import java.util.List;

import org.gs1.smartcity.capturing.eventdata.EventDataManager;
import org.gs1.smartcity.capturing.eventdata.EventDataManagerFactory;
import org.gs1.smartcity.capturing.masterdata.MasterDataManager;
import org.gs1.smartcity.capturing.masterdata.MasterDataManagerFactory;

public abstract class ExistingServiceManager {

	protected UrlGenerator urlGenerator;
	protected MasterDataTranslator vocTranslator;
	protected EventTranslator eventTranslator;
	protected MasterDataManager masterDataManager;
	protected EventDataManager eventDataManager;
	
	public ExistingServiceManager(String type) {
		
		urlGenerator = (new UrlGeneratorFactory()).getUrlGenerator(type);
		vocTranslator = (new MasterDataTransFactory()).getTrans(type);
		eventTranslator = (new EventTransFactory()).getTrans(type);
		masterDataManager = (new MasterDataManagerFactory()).getManager(type);
		eventDataManager = (new EventDataManagerFactory()).getManager(type);
	}
	
	public abstract String queryExistingServiceData(String serviceType, String infoType, List<String> params);
	public abstract String queryExistingServiceEvent(String serviceType, String infoType, List<String> params);
	public abstract void registerMasterData(String data);
	public abstract void registerEventData(String data);

}
