package org.gs1.smartcity.db.mongo.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.service.ServiceType;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.springframework.data.mongodb.core.query.Update;

public class ServiceDAO extends DataAccessObject {
	
	public boolean register(String serviceName, String serviceUrl){

		ServiceType service = new ServiceType();
		service.setServiceName(serviceName);
		service.setServiceUrl(serviceUrl);

		if(mongoOps.findOne(query(where("serviceUrl").is(serviceUrl)), ServiceType.class, "Service") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(service, "Service");
		return true;
	}
	
	public String queryKey(String serviceUrl){

		ServiceType service = mongoOps.findOne(query(where("serviceUrl").is(serviceUrl)), ServiceType.class, "Service");

		if(service == null) {
			return null;
		}
		return service.getServiceName();
	}
	
	public boolean update(String serviceName, String serviceUrl) {

		Update update = new Update();
		update.set("serviceName", serviceName);
		mongoOps.updateFirst(query(where("serviceUrl").is(serviceUrl)), update, ServiceType.class, "Service");
		
		return true;
	}

	public boolean delete(String serviceUrl) {

		mongoOps.remove(query(where("serviceUrl").is(serviceUrl)), ServiceType.class, "Service");
		
		return true;
	}

	public boolean putCheckNum(int checkNum) {

		CheckNumType service = new CheckNumType();
		service.setType("service");
		service.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("service")), CheckNumType.class, "CheckNum");
		mongoOps.insert(service, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType service = mongoOps.findOne(query(where("type").is("service")), CheckNumType.class, "CheckNum");

		return service.getCheckNum();
	}

}
