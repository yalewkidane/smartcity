package org.gs1.smartcity.capturing.services.bus;

import javax.xml.namespace.QName;

import org.gs1.epcglobal.epcis.ActionType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.BusinessTransactionListType;
import org.gs1.epcglobal.epcis.BusinessTransactionType;
import org.gs1.epcglobal.epcis.ObjectEventExtensionType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.smartcity.capturing.eventdata.EventDataManager;
import org.gs1.smartcity.datatype.bus.BusDriverLifeEventType;
import org.gs1.smartcity.datatype.bus.BusLifeEventType;

public class BusEventDataManager extends EventDataManager {

	public ObjectEventType modelingObjectEvent(String type, Object object) {

		if(type.equals(BusServiceFactory.BUS_LIFE_INFO)) {
			return busLifeModeling((BusLifeEventType) object);
		} else if(type.equals(BusServiceFactory.BUS_DRIVER_LIFE_INFO)) {
			return busDriverLifeModeling((BusDriverLifeEventType) object);
		}
		return null;
	}

	private ObjectEventType busLifeModeling(BusLifeEventType event) {

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
		for(int i = 0; i < event.getBizTransactionList().size(); i++) {
			BusinessTransactionType bizTransaction = new BusinessTransactionType();
			bizTransaction.setType("urn:gs1:epcisapp:bus:vehicle:life");
			bizTransaction.setValue(event.getBizTransactionList().get(i));
			bizTransactionList.getBizTransactions().add(bizTransaction);
		}
		objectEvent.setBizTransactionList(bizTransactionList);

		ObjectEventExtensionType extension = new ObjectEventExtensionType();
		for(int i = 0; i < event.getExtensions().size(); i++) {
			QName registration = new QName("", event.getExtensions().get(i).getName());
			extension.getOtherAttributes().put(registration, event.getExtensions().get(i).getValue());
		}

		return objectEvent;
	}

	private ObjectEventType busDriverLifeModeling(BusDriverLifeEventType event) {

		ObjectEventType objectEvent = new ObjectEventType();

		objectEvent.setAction(ActionType.OBSERVE);
		objectEvent.setEventTime(event.getEventTime());
		objectEvent.setEpcList(event.getEpcList());

		BusinessLocationType bizLocation = new BusinessLocationType();
		bizLocation.setId(event.getBizLocation());
		objectEvent.setBizLocation(bizLocation);

		BusinessTransactionListType bizTransactionList = new BusinessTransactionListType();
		for(int i = 0; i < event.getBizTransactionList().size(); i++) {
			BusinessTransactionType bizTransaction = new BusinessTransactionType();
			bizTransaction.setType("urn:gs1:epcisapp:bus:driver:life");
			bizTransaction.setValue(event.getBizTransactionList().get(i));
			bizTransactionList.getBizTransactions().add(bizTransaction);
		}
		objectEvent.setBizTransactionList(bizTransactionList);

		ObjectEventExtensionType extension = new ObjectEventExtensionType();
		for(int i = 0; i < event.getExtensions().size(); i++) {
			QName registration = new QName("", event.getExtensions().get(i).getName());
			extension.getOtherAttributes().put(registration, event.getExtensions().get(i).getValue());
		}

		return objectEvent;
	}

}
