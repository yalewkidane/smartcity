package org.gs1.smartcity.services;

import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.gs1.smartcity.datatype.ServiceListType;

public class ServiceListMarshaller {
	
	private ServiceListType serviceList;
	
	public ServiceListMarshaller() {
		
		serviceList = new ServiceListType();
	}
	
	public void make(List<String> services) {
		
		serviceList.getServiceList().addAll(services);
	}
	
	public String marshal() {
		
		JAXBContext jc = null;
		try {
			jc = JAXBContext.newInstance(ServiceListType.class);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		
		Marshaller m = null;
		try {
			m = jc.createMarshaller();
		} catch (JAXBException e2) {
			e2.printStackTrace();
		}
		
		try {
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch (PropertyException e1) {
			e1.printStackTrace();
		}
		
		Writer writer = new StringWriter();
		try {
			m.marshal(serviceList, writer);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		
		String s = writer.toString();

		return s;
	}

}
