package org.gs1.smartcity.datatype.bus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.gs1.epcglobal.EPC;
import org.gs1.epcglobal.epcis.EPCListType;
import org.gs1.smartcity.datatype.bus.event.BusExtension;

public class BusObjectEventType {

	protected Calendar eventTime;
	protected EPCListType epcList;
	protected String bizLocation;
	protected String bizStep;
	protected List<String> bizTransactionList;
	protected BusExtension extension;

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

	public String getBizStep() {

		return bizStep;
	}

	public void setBizStep(String value) {

		this.bizStep = value;
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

	public BusExtension getExtension() {

		if(extension==null) {
			extension = new BusExtension();
		}

		return extension;
	}

	public void setExtension(BusExtension value) {

		this.extension = value;
	}
}
