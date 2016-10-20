package org.gs1.smartcity.capturing.services;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.gs1.smartcity.util.CheckBit;

public class Test {

	public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException {

		DAOFactory factory = new DAOFactory();
		DataAccessObject dao = factory.getDAO(DAOFactory.GLN);
//		
//		dao.register("8001378", "8802345123456");
//		
//		String s = dao.queryKey("8001378");
//		
//		System.out.println(s);
		
		//ExistingServiceManager m = (new ExistingServiceManagerFactory()).getManager(ServiceFactory.BUS);
		
		CheckBit cb = new CheckBit();
		dao.putCheckNum("1111");
		String reference = String.valueOf(Long.parseLong(dao.getCheckNum()) + 1);
		String id = "88012345" + "0000".substring(0, 4-reference.length()) + reference;
		id = id + cb.generateCheckBit(id);
		System.out.println(id);
		
	}

}