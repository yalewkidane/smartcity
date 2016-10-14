package org.gs1.smartcity.capturing.services;

public class TransFactory {
	
	public Translator getTrans(String type) {
		
		Translator trans = null;
		
		if(type.equals("busanBus")) {
			
			trans = new BusanBusTranslator();
		}
		
		return trans;
		
	}

}
