package org.gs1.smartcity.etc;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Identification {

	protected DocumentBuilderFactory factory;
	protected DocumentBuilder builder;
	protected Document document;
	
	private static final String busanPrefix = "8801234";
	private static final String daejeonPrefix = "8802345";

	public Identification() {

		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void identifyBusLine(String data) {

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			DAOFactory factory = new DAOFactory();
			DataAccessObject daoC = factory.getDAO(DAOFactory.COMPANY_PREFIX);

			String companyPrefix = daoC.queryKey(element.getElementsByTagName("companyid").item(0).getFirstChild().getNodeValue().substring(0, 2));

			DataAccessObject daoG = factory.getDAO(DAOFactory.GSRN);
			daoG.register(element.getElementsByTagName("lineId").item(0).getFirstChild().getNodeValue(), companyPrefix + "000000000".substring(Integer.toString(i+1).length()) + (i+1));
		}
	}

	public void identifyBusStop(String data) {

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			DAOFactory factory = new DAOFactory();
			DataAccessObject daoG = factory.getDAO(DAOFactory.GLN);
			daoG.register(element.getElementsByTagName("bstopId").item(0).getFirstChild().getNodeValue(), busanPrefix + "000000".substring(Integer.toString(i+1).length()) + (i+1));
		}
	}

	public void identifyVehicle(String id, String data) {

		List<String> vehicles = new ArrayList<String>();

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			if(element.getElementsByTagName("carNo").item(0) != null)
				vehicles.add(element.getElementsByTagName("carNo").item(0).getFirstChild().getNodeValue());
		}

		DataAccessObject daoC = new VehicleDAO();

		for(String vehicle : vehicles) {

			if(daoC.queryKey(vehicle) == null) {
				daoC.register(vehicle, id);
				System.out.println(id + ":" + vehicle);
			}
		}




	}

	public void identifyCompanyPrefix(String data) {

		List<String> companies = new ArrayList<String>();

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			companies.add(element.getElementsByTagName("companyid").item(0).getFirstChild().getNodeValue());
		}

		for(String company : companies) {

			System.out.println(company);
		}
	}
}
