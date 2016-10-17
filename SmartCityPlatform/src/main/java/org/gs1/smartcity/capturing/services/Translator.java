package org.gs1.smartcity.capturing.services;

import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.eventdata.EventDataManager;
import org.gs1.smartcity.capturing.masterdata.MasterDataManager;

public abstract class Translator {
	
	protected MasterDataManager mdm;
	protected EventDataManager edm;

	public abstract VocabularyType masterDataTranslate(String type, String data);
	public abstract ObjectEventType eventDataTranslate(String type, String data);

}
