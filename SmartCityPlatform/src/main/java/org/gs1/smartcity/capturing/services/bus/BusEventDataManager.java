package org.gs1.smartcity.capturing.services.bus;

import java.util.List;

import javax.xml.namespace.QName;

import org.gs1.epcglobal.epcis.ActionType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.BusinessTransactionListType;
import org.gs1.epcglobal.epcis.BusinessTransactionType;
import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.ObjectEventExtensionType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.smartcity.capturing.eventdata.EventDataManager;
import org.gs1.smartcity.datatype.bus.BusDriverLifeEventType;
import org.gs1.smartcity.datatype.bus.BusLifeEventType;

public class BusEventDataManager extends EventDataManager {

	@SuppressWarnings("unchecked")
	public EventListType modelingObjectEvent(String type, Object object) {

		if(type.equals(BusServiceFactory.BUS_LIFE_INFO)) {
			return busLifeModeling((List<BusLifeEventType>) object);
		} else if(type.equals(BusServiceFactory.BUS_DRIVER_LIFE_INFO)) {
			return busDriverLifeModeling((List<BusDriverLifeEventType>) object);
		}

		return null;
	}

	private EventListType busLifeModeling(List<BusLifeEventType> eventList) {

		EventListType epcisEventList = new EventListType();

		for(int i = 0; i < eventList.size(); i++) {
			BusLifeEventType event = eventList.get(i);
			ObjectEventType objectEvent = new ObjectEventType();

			objectEvent.setAction(ActionType.OBSERVE);
			objectEvent.setEventTime(event.getEventTime());
			objectEvent.setEpcList(event.getEpcList());

			BusinessLocationType bizLocation = new BusinessLocationType();
			bizLocation.setId(event.getBizLocation());
			objectEvent.setBizLocation(bizLocation);

			if(event.getBizStep() != null) {
				objectEvent.setBizStep(event.getBizStep());
			}

			BusinessTransactionListType bizTransactionList = new BusinessTransactionListType();
			for(int j = 0; j < event.getBizTransactionList().size(); j++) {
				BusinessTransactionType bizTransaction = new BusinessTransactionType();
				bizTransaction.setType("urn:gs1:epcisapp:bus:vehicle:life");
				bizTransaction.setValue(event.getBizTransactionList().get(j));
				bizTransactionList.getBizTransactions().add(bizTransaction);
			}
			objectEvent.setBizTransactionList(bizTransactionList);

			ObjectEventExtensionType extension = new ObjectEventExtensionType();
			for(int j = 0; i < event.getExtensions().size(); j++) {
				QName registration = new QName("", event.getExtensions().get(j).getName());
				extension.getOtherAttributes().put(registration, event.getExtensions().get(j).getValue());
			}

			epcisEventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(objectEvent);
		}

		return epcisEventList;
	}

	private EventListType busDriverLifeModeling(List<BusDriverLifeEventType> eventList) {

		EventListType epcisEventList = new EventListType();

		for(int i = 0; i < eventList.size(); i++) {
			BusDriverLifeEventType event = eventList.get(i);
			ObjectEventType objectEvent = new ObjectEventType();

			objectEvent.setAction(ActionType.OBSERVE);
			objectEvent.setEventTime(event.getEventTime());
			objectEvent.setEpcList(event.getEpcList());

			BusinessLocationType bizLocation = new BusinessLocationType();
			bizLocation.setId(event.getBizLocation());
			objectEvent.setBizLocation(bizLocation);

			BusinessTransactionListType bizTransactionList = new BusinessTransactionListType();
			for(int j = 0; j < event.getBizTransactionList().size(); j++) {
				BusinessTransactionType bizTransaction = new BusinessTransactionType();
				bizTransaction.setType("urn:gs1:epcisapp:bus:driver:life");
				bizTransaction.setValue(event.getBizTransactionList().get(j));
				bizTransactionList.getBizTransactions().add(bizTransaction);
			}
			objectEvent.setBizTransactionList(bizTransactionList);

			ObjectEventExtensionType extension = new ObjectEventExtensionType();
			for(int j = 0; j < event.getExtensions().size(); j++) {
				QName registration = new QName("", event.getExtensions().get(j).getName());
				extension.getOtherAttributes().put(registration, event.getExtensions().get(j).getValue());
			}
			
			epcisEventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(objectEvent);
		}
		return epcisEventList;
	}

}
