package org.gs1.smartcity.etc;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.smartcity.datatype.identification.CompanyPrefixType;
import org.gs1.smartcity.datatype.identification.GLNType;
import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.gs1.smartcity.db.mongo.identification.CompanyPrefixDAO;
import org.gs1.smartcity.db.mongo.identification.GlnDAO;
import org.gs1.smartcity.util.CheckBit;
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

	private static final String busanPrefix = "88012345";
	private static final String daejeonPrefix = "88023456";

	public Identification() {

		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void identifyBusLineB(String data) {

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DAOFactory factory = DAOFactory.getInstance();
		DataAccessObject daoG = factory.getDAO(DAOFactory.GSRN);

		NodeList nList = document.getElementsByTagName("itemList");

		int j = daoG.getCheckNum();
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			if(element.getElementsByTagName("ROUTE_CD").item(0) == null) continue;
			if(daoG.queryKey(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue()) == null) {

				CheckBit check = new CheckBit();
				String gsrn = busanPrefix + "000000000".substring(Integer.toString(j).length()) + j;
				gsrn = gsrn + check.generateCheckBit(gsrn);

				j++;

				daoG.register(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue(), gsrn);

				System.out.println(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue() + " : " + gsrn);
			}
		}
		daoG.putCheckNum(j);
	}

	public void identifyBusLineD(String data) {

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DAOFactory factory = DAOFactory.getInstance();
		DataAccessObject daoG = factory.getDAO(DAOFactory.GSRN);

		NodeList nList = document.getElementsByTagName("itemList");

		int j = daoG.getCheckNum();
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			if(element.getElementsByTagName("ROUTE_CD").item(0) == null) continue;
			if(daoG.queryKey(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue()) == null) {

				CheckBit check = new CheckBit();
				String gsrn = daejeonPrefix + "000000000".substring(Integer.toString(j).length()) + j;
				gsrn = gsrn + check.generateCheckBit(gsrn);

				j++;

				daoG.register(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue(), gsrn);

				System.out.println(element.getElementsByTagName("ROUTE_CD").item(0).getFirstChild().getNodeValue() + " : " + gsrn);
			}
		}
		daoG.putCheckNum(j);
	}

	public void identifyBusStop(String data) {

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DAOFactory factory = DAOFactory.getInstance();
		DataAccessObject daoG = factory.getDAO(DAOFactory.GLN);

		NodeList nList = document.getElementsByTagName("itemList");

		int j = daoG.getCheckNum();
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;
			if(element.getElementsByTagName("BUS_NODE_ID").item(0) == null) continue;
			if(daoG.queryKey(element.getElementsByTagName("BUS_NODE_ID").item(0).getFirstChild().getNodeValue()) == null) {

				CheckBit check = new CheckBit();
				String g = daejeonPrefix + "0000".substring(Integer.toString(j).length()) + j;
				g = g + check.generateCheckBit(g);

				j++;
				daoG.register(element.getElementsByTagName("BUS_NODE_ID").item(0).getFirstChild().getNodeValue(), g);

				System.out.println(element.getElementsByTagName("BUS_NODE_ID").item(0).getFirstChild().getNodeValue() + " : " + g);
			}
		}
		daoG.putCheckNum(j);
	}

	public void identifyBusStop() {

		GlnDAO dao = new GlnDAO();
		List<GLNType> list = dao.queryAll();

		for (int i = 0; i < list.size(); i++) {
			GLNType gln = list.get(i);
			if(dao.queryKey(gln.getObjectID()) != null) {
				continue;
			}

			CheckBit check = new CheckBit();
			String g = busanPrefix + "0000".substring(Integer.toString(i+1).length()) + (i+1);
			g = g + check.generateCheckBit(g);
			dao.register(gln.getObjectID(), g);
		}
	}

	public void identifyVehicle(String data) {

		try {
			document = builder.parse(new InputSource(new StringReader(data)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		NodeList nList = document.getElementsByTagName("itemList");

		DAOFactory factory = DAOFactory.getInstance();
		DataAccessObject daoC = factory.getDAO(DAOFactory.COMPANY_PREFIX);
		DataAccessObject daoG = factory.getDAO(DAOFactory.GIAI);

		int j = daoG.getCheckNum();
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			if(element.getElementsByTagName("CAR_REG_NO").item(0) == null) {
				continue;
			}

			if(daoG.queryKey(element.getElementsByTagName("CAR_REG_NO").item(0).getFirstChild().getNodeValue()) == null) {
				String companyPrefix = daoC.queryKey(element.getElementsByTagName("COMP_CD").item(0).getFirstChild().getNodeValue());

				String giai = companyPrefix + "00000000".substring(Integer.toString(j).length()) + j;

				j++;

				daoG.register(element.getElementsByTagName("CAR_REG_NO").item(0).getFirstChild().getNodeValue(), giai);

				System.out.println(element.getElementsByTagName("CAR_REG_NO").item(0).getFirstChild().getNodeValue() + " : " + giai);
			}
		}
		daoG.putCheckNum(j);
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

		NodeList nList = document.getElementsByTagName("itemList");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			if(element.getElementsByTagName("COMP_CD").item(0) != null)
				companies.add(element.getElementsByTagName("COMP_CD").item(0).getFirstChild().getNodeValue());
		}

		CompanyPrefixDAO dao = new CompanyPrefixDAO();

		for(int i = 0; i < companies.size(); i ++) {
			String company = companies.get(i);
			dao.register(company, Integer.toString(88030035 + i));

		}
	}

	public void identifyCompany() {

		CompanyPrefixDAO dao = new CompanyPrefixDAO();
		List<CompanyPrefixType> companies = dao.queryAll();

		GlnDAO daoG = new GlnDAO();
		int j = daoG.getCheckNum();
		for(int i = 0; i < companies.size(); i++) {

			CompanyPrefixType company = companies.get(i);
			int pre = Integer.valueOf(company.getCompanyPrefix());
			if(pre >= 88030035) { 
				CheckBit check = new CheckBit();
				String g = daejeonPrefix + j;
				j++;
				g = g + check.generateCheckBit(g);
				System.out.println(company.getCompanyID() + " : " + g);
				daoG.register(company.getCompanyID(), g);
			}
		}
		daoG.putCheckNum(j);

	}
	
	public List<String>	getStops(String data) {
		
		List<String> list = new ArrayList<String>();
		
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

			if(element.getElementsByTagName("arsNo").item(0) != null)
				list.add(element.getElementsByTagName("arsNo").item(0).getFirstChild().getNodeValue());
		}
		
		return list;
	}
}
