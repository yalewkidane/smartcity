package org.gs1.smartcity.capturing.services;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;

public class ExistingServiceManager {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		QueryProcessor queryProcessor = new QueryProcessor();
		
		TransFactory transFactory = new TransFactory();
		Translator trans = transFactory.getTrans(ServiceUrlFactory.BUSAN_BUS);
		
		ServiceUrlFactory urlFactory = new ServiceUrlFactory();
		UrlGenerator urlGenerator = urlFactory.getUrlGenerator(ServiceUrlFactory.BUSAN_BUS);
		
		String url = urlGenerator.generate(BusInfoFactory.BUSAN_BUS_LINE_INFO, "", null);
		String data = queryProcessor.query(url);
		
		trans.translate(BusInfoFactory.BUSAN_BUS_LINE_INFO, data);
		
		//register master data - bus line, bus stop
		//register event data periodically - bus arrival, line-stop, bus location
		

	}

}
