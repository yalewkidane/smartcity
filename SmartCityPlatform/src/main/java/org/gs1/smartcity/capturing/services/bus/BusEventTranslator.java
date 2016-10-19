package org.gs1.smartcity.capturing.services.bus;

import java.io.IOException;
import java.io.StringReader;
import java.util.Calendar;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.EPCISDataAggregator;
import org.gs1.smartcity.capturing.services.EventTranslator;
import org.gs1.smartcity.datatype.ExtensionType;
import org.gs1.smartcity.datatype.bus.BusLifeEventType;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class BusEventTranslator extends EventTranslator {
	
	private static final String DIRECTION = "direction";

	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document document;

	public BusEventTranslator() throws ParserConfigurationException {

		edm = new BusEventDataManager();

		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}

	public EventListType translate(String type, String data) {

		if(type.equals(BusServiceFactory.BUSAN_BUS_LINE_ROUTE)) {
			try {
				return translateBusanBusLifeInfo(data);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (DOMException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} else if(type.equals(BusServiceFactory.DAEJEON_BUS_LINE_POS)) {
			try {
				return translateDaejeonBusLifeInfo(data);
			} catch (DOMException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private EventListType translateBusanBusLifeInfo(String data) throws SAXException, IOException, DOMException, JAXBException {
		
		EventListType eventList = new EventListType();

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			EPCISDataAggregator aggregator = new EPCISDataAggregator();

			BusLifeEventType event = new BusLifeEventType();
			event.setEventTime(Calendar.getInstance());

			if(element.getElementsByTagName("carNo").item(0) != null) {
				VocabularyType voc = aggregator.getVocabulary("http://epcis.example.com/bus/vehicle/number", element.getElementsByTagName("carNo").item(0).getFirstChild().getNodeValue());
				event.addEpc(voc.getVocabularyElementList().getVocabularyElements().get(0).getId());
				event.addEpc(voc.getVocabularyElementList().getVocabularyElements().get(0).getAttributes().get(1).getContent().get(0).toString());
			} else if(element.getElementsByTagName("lineNo").item(0) != null) {
				event.addEpc(aggregator.getVocabulary("http://epcis.example.com/bus/line/number", element.getElementsByTagName("lineNo").item(0).getFirstChild().getNodeValue()).getVocabularyElementList().getVocabularyElements().get(0).getId());
			}
			if(element.getElementsByTagName("nodeId").item(0) != null) {
				event.setBizLocation(aggregator.getVocabulary("http://epcis.example.com/bus/stop/id", element.getElementsByTagName("nodeId").item(0).getFirstChild().getNodeValue()).getVocabularyElementList().getVocabularyElements().get(0).getId());
			} else if(element.getElementsByTagName("arsNo").item(0) != null) {
				event.setBizLocation(aggregator.getVocabulary("http://epcis.example.com/bus/stop/number", element.getElementsByTagName("arsNo").item(0).getFirstChild().getNodeValue()).getVocabularyElementList().getVocabularyElements().get(0).getId());
			}
			if(element.getElementsByTagName("direction").item(0) != null) {
				event.addBizTransaction(DIRECTION);

				ExtensionType extension = new ExtensionType();
				extension.setName(DIRECTION);
				extension.setValue(element.getElementsByTagName("direction").item(0).getFirstChild().getNodeValue());
				event.addExtension(extension);
			}

			ObjectEventType objectEvent = edm.modelingObjectEvent(BusServiceFactory.BUS_LIFE_INFO, event);
			eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(objectEvent);
		}
		
		return eventList;
	}

	private EventListType translateDaejeonBusLifeInfo(String data) throws SAXException, IOException, DOMException, JAXBException {

		EventListType eventList = new EventListType();

		document = builder.parse(new InputSource(new StringReader(data)));

		NodeList nList = document.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;

			EPCISDataAggregator aggregator = new EPCISDataAggregator();

			BusLifeEventType event = new BusLifeEventType();
			event.setEventTime(Calendar.getInstance());

			if(element.getElementsByTagName("carNo").item(0) != null) {
				VocabularyType voc = aggregator.getVocabulary("http://epcis.example.com/bus/vehicle/number", element.getElementsByTagName("carNo").item(0).getFirstChild().getNodeValue());
				event.addEpc(voc.getVocabularyElementList().getVocabularyElements().get(0).getId());
				event.addEpc(voc.getVocabularyElementList().getVocabularyElements().get(0).getAttributes().get(1).getContent().get(0).toString());
			} else if(element.getElementsByTagName("lineNo").item(0) != null) {
				event.addEpc(aggregator.getVocabulary("http://epcis.example.com/bus/line/number", element.getElementsByTagName("lineNo").item(0).getFirstChild().getNodeValue()).getVocabularyElementList().getVocabularyElements().get(0).getId());
			}
			if(element.getElementsByTagName("nodeId").item(0) != null) {
				event.setBizLocation(aggregator.getVocabulary("http://epcis.example.com/bus/stop/id", element.getElementsByTagName("nodeId").item(0).getFirstChild().getNodeValue()).getVocabularyElementList().getVocabularyElements().get(0).getId());
			} else if(element.getElementsByTagName("arsNo").item(0) != null) {
				event.setBizLocation(aggregator.getVocabulary("http://epcis.example.com/bus/stop/number", element.getElementsByTagName("arsNo").item(0).getFirstChild().getNodeValue()).getVocabularyElementList().getVocabularyElements().get(0).getId());
			}
			if(element.getElementsByTagName("direction").item(0) != null) {
				event.addBizTransaction(DIRECTION);

				ExtensionType extension = new ExtensionType();
				extension.setName(DIRECTION);
				extension.setValue(element.getElementsByTagName("direction").item(0).getFirstChild().getNodeValue());
				event.addExtension(extension);
			}

			ObjectEventType objectEvent = edm.modelingObjectEvent(BusServiceFactory.BUS_LIFE_INFO, event);
			eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(objectEvent);
		}
		
		return eventList;
	}
}