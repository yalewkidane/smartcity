package org.gs1.smartcity.capturing.services;

import org.gs1.epcglobal.epcis.VocabularyListType;
import org.gs1.smartcity.capturing.masterdata.MasterDataManager;

public abstract class VocabularyTranslator {
	
	protected MasterDataManager mdm;

	public abstract VocabularyListType translate(String type, String data);

}
