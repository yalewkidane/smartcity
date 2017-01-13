package org.gs1.smartcity.db.mongo.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.service.ServiceClassType;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.springframework.data.mongodb.core.query.Update;

public class ServiceClassDAO extends DataAccessObject {

	public boolean register(String serviceID, String serviceName){

		ServiceClassType serviceClass = new ServiceClassType();
		serviceClass.setServiceID(serviceID);
		serviceClass.setServiceName(serviceName);

		if(mongoOps.findOne(query(where("serviceID").is(serviceID)), ServiceClassType.class, "ServiceClass") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(serviceClass, "ServiceClass");
		return true;
	}
	
	public String queryKey(String serviceName){

		ServiceClassType serviceClass = mongoOps.findOne(query(where("serviceName").is(serviceName)), ServiceClassType.class, "ServiceClass");

		if(serviceClass == null) {
			return null;
		}
		return serviceClass.getServiceID();
	}
	
	public boolean update(String serviceID, String serviceName) {

		Update update = new Update();
		update.set("serviceName", serviceName);
		mongoOps.updateFirst(query(where("serviceID").is(serviceID)), update, ServiceClassType.class, "ServiceClass");
		
		return true;
	}

	public boolean delete(String serviceID) {

		mongoOps.remove(query(where("serviceID").is(serviceID)), ServiceClassType.class, "ServiceClass");
		
		return true;
	}

	public boolean putCheckNum(int checkNum) {

		CheckNumType serviceClass = new CheckNumType();
		serviceClass.setType("serviceClass");
		serviceClass.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("serviceClass")), CheckNumType.class, "CheckNum");
		mongoOps.insert(serviceClass, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType serviceClass = mongoOps.findOne(query(where("type").is("serviceClass")), CheckNumType.class, "CheckNum");

		return serviceClass.getCheckNum();
	}
}
