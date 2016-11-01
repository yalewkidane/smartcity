package org.gs1.smartcity.capturing.services;

import org.gs1.smartcity.capturing.services.bus.BusMasterDataTranslator;

public class MasterDataTransFactory {

	public MasterDataTranslator getTrans(String type) {

		MasterDataTranslator trans = null;

		if(type.equals(ServiceFactory.BUS)) {

			trans = new BusMasterDataTranslator();
		}

		return trans;

	}

}