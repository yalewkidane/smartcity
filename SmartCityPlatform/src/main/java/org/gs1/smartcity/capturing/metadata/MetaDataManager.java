package org.gs1.smartcity.capturing.metadata;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.smartcity.capturing.DataManager;

public abstract class MetaDataManager extends DataManager {
	
	protected MetadataMarshaller marshaller;
	protected EventListType eventList;
	
	public MetaDataManager() {
		
		marshaller = new MetadataMarshaller();
		eventList = new EventListType();
	}
	
}
