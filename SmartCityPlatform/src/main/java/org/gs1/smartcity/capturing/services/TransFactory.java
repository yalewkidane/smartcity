package org.gs1.smartcity.capturing.services;

import org.gs1.smartcity.capturing.services.bus.BusTranslator;

public class TransFactory {
	
	public Translator getTrans(String type) {
		
		Translator trans = null;
		
		if(type.equals("busanBus")) {
			
			trans = new BusTranslator();
		}
		
		return trans;
		
	}

}
