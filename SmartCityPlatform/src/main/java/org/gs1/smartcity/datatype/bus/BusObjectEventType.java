package org.gs1.smartcity.datatype.bus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.gs1.epcglobal.EPC;
import org.gs1.epcglobal.epcis.EPCListType;
import org.w3c.dom.Element;

public class BusObjectEventType {

	protected Calendar eventTime;
	protected EPCListType epcList;
	protected String bizLocation;
	protected List<String> bizTransactionList;
	protected List<Element> extensions;
	
	public BusObjectEventType() {
		
		epcList = new EPCListType();
	}
	
	public Calendar getEventTime() {

		return eventTime;
	}

	public void setEventTime(Calendar value) {

		this.eventTime = value;
	}

	public EPCListType getEpcList() {

		return epcList;
	}

	public void setEpcList(EPCListType value) {

		this.epcList = value;
	}
	
	public void addEpc(EPC value) {
		
		this.epcList.getEpcs().add(value);
	}
	
	public void addEpc(String value) {
		
		EPC e = new EPC();
		e.setValue(value);
		this.epcList.getEpcs().add(e);
	}

	public String getBizLocation() {

		return bizLocation;
	}

	public void setBizLocation(String value) {

		this.bizLocation = value;
	}

	public List<String> getBizTransactionList() {

		return bizTransactionList;
	}

	public void setBizTransactionList(List<String> value) {

		this.bizTransactionList = value;
	}
	
	public void addBizTransaction(String value) {
		
		if(this.bizTransactionList == null) {
			this.bizTransactionList = new ArrayList<String>();
		}
		this.bizTransactionList.add(value);
	}

	public List<Element> getExtensions() {

		return extensions;
	}

	public void setExtensions(List<Element> value) {

		this.extensions = value;
	}
	
	public void addExtension(Element value) {
		
		if(this.extensions == null) {
			this.extensions = new ArrayList<Element>();
		}
		this.extensions.add(value);
	}
}
