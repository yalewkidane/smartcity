package org.gs1.smartcity.capturing.masterdata;

import org.gs1.epcglobal.epcis.VocabularyType;

public abstract class MasterDataManager {
	
	protected VocabularyType voc;
	
	public MasterDataManager() {
		voc = new VocabularyType();
	}
	
	public abstract VocabularyType modelingVocabulary(String type, Object data);

}