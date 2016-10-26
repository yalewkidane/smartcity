package org.gs1.smartcity.capturing.services.bus;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.gs1.epcglobal.EPC;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.EPCISDataAggregator;
import org.gs1.smartcity.capturing.services.EventTranslator;
import org.gs1.smartcity.capturing.services.ServiceFactory;
import org.gs1.smartcity.datatype.bus.BusLifeEventType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class BusEventTranslator extends EventTranslator {

	private static final String DIRECTION = "http://epcis.example.com/bus/life/direction";

	public Object translate(String serviceType, String infoType, String data) {

		if(serviceType.equals(ServiceFactory.BUSAN_BUS)) {
			if(infoType.equals(BusServiceFactory.BUS_LINE_ROUTE)) {
				return translateBusanBusLifeInfo(data);
			}
		} else if(serviceType.equals(ServiceFactory.DAEJEON_BUS)) {
			if(infoType.equals(BusServiceFactory.BUS_LINE_POS)) {
				return translateDaejeonBusLifeInfo(data);
			}
		}
		return null;
	}

	private List<BusLifeEventType> translateBusanBusLifeInfo(String data) {

		List<BusLifeEventType> eventList = new ArrayList<BusLifeEventType>();

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

			//EPCISDataAggregator aggregator = new EPCISDataAggregator();

			BusLifeEventType event = new BusLifeEventType();
			event.setEventTime(Calendar.getInstance());

			if(element.getElementsByTagName("carNo").item(0) != null) {
				EPC epc = new EPC();
				epc.setValue("00000000");
				event.addEpc(epc);
				//VocabularyType voc = aggregator.getVocabulary("http://epcis.example.com/bus/vehicle/number", element.getElementsByTagName("carNo").item(0).getFirstChild().getNodeValue());
				//event.addEpc(voc.getVocabularyElementList().getVocabularyElements().get(0).getId());
				//event.addEpc(voc.getVocabularyElementList().getVocabularyElements().get(0).getAttributes().get(1).getContent().get(0).toString());
			} else {
				continue;
			}
			if(element.getElementsByTagName("nodeId").item(0) != null) {
				event.setBizLocation("000000");
				//event.setBizLocation(aggregator.getVocabulary("http://epcis.example.com/bus/stop/id", element.getElementsByTagName("nodeId").item(0).getFirstChild().getNodeValue()).getVocabularyElementList().getVocabularyElements().get(0).getId());
			} else if(element.getElementsByTagName("arsNo").item(0) != null) {
				event.setBizLocation("000000");
				//event.setBizLocation(aggregator.getVocabulary("http://epcis.example.com/bus/stop/number", element.getElementsByTagName("arsNo").item(0).getFirstChild().getNodeValue()).getVocabularyElementList().getVocabularyElements().get(0).getId());
			}
			if(element.getElementsByTagName("direction").item(0) != null) {
				event.addBizTransaction(DIRECTION);

				Element extension = document.createElement("direction");
				extension.setAttribute("direction", element.getElementsByTagName("direction").item(0).getFirstChild().getNodeValue());
				event.addExtension(extension);
			}

			eventList.add(event);
		}

		return eventList;
	}

	private List<BusLifeEventType> translateDaejeonBusLifeInfo(String data) {

		List<BusLifeEventType> eventList = new ArrayList<BusLifeEventType>();

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

				Element extension = document.createElement(DIRECTION);
				extension.setNodeValue(element.getElementsByTagName("direction").item(0).getFirstChild().getNodeValue());
				event.addExtension(extension);
			}

			eventList.add(event);
		}

		return eventList;
	}
}