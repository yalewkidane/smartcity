package org.gs1.smartcity.capturing.services;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

public class Test {

	public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException {

		ExistingServiceManager m = new ExistingServiceManager();
		
		m.queryData();
		
	}

}