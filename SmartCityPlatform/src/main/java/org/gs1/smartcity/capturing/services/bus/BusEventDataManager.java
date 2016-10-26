package org.gs1.smartcity.capturing.services.bus;

import java.util.List;

import org.gs1.epcglobal.epcis.ActionType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.BusinessTransactionListType;
import org.gs1.epcglobal.epcis.BusinessTransactionType;
import org.gs1.epcglobal.epcis.ObjectEventExtension2Type;
import org.gs1.epcglobal.epcis.ObjectEventExtensionType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.smartcity.capturing.eventdata.EventDataManager;
import org.gs1.smartcity.datatype.bus.BusDriverLifeEventType;
import org.gs1.smartcity.datatype.bus.BusLifeEventType;

public class BusEventDataManager extends EventDataManager {

	@SuppressWarnings("unchecked")
	public String modeling(String type, Object object) {

		String result = null;

		if(type.equals(BusServiceFactory.BUS_LINE_ROUTE)) {
			busLifeModeling((List<BusLifeEventType>) object);
		} else if(type.equals(BusServiceFactory.BUS_DRIVER_LIFE_INFO)) {
			busDriverLifeModeling((List<BusDriverLifeEventType>) object);
		}

		marshaller.make(eventList);
		result = marshaller.marshal();

		return result;
	}

	private void busLifeModeling(List<BusLifeEventType> eventList) {

		for(int i = 0; i < eventList.size(); i++) {
			BusLifeEventType event = eventList.get(i);
			ObjectEventType objectEvent = new ObjectEventType();

			objectEvent.setAction(ActionType.OBSERVE);
			objectEvent.setEventTime(event.getEventTime());
			objectEvent.setEventTimeZoneOffset("+09:00");
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
			for(int j = 0; j < event.getExtensions().size(); j++) {
				ObjectEventExtension2Type extension2 = new ObjectEventExtension2Type();
				extension2.getAnies().add(event.getExtensions().get(j));
				extension.setExtension(extension2);
				System.out.println(extension.getExtension().getAnies().get(0).getAttribute("direction"));
			}

			this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(objectEvent);
		}
	}

	private void busDriverLifeModeling(List<BusDriverLifeEventType> eventList) {

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
				ObjectEventExtension2Type extension2 = new ObjectEventExtension2Type();
				extension2.getAnies().add(event.getExtensions().get(j));
				extension.setExtension(extension2);
			}

			this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(objectEvent);
		}
	}

}
