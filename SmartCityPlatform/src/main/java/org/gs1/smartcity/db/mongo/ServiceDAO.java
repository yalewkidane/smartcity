package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.ServiceType;
import org.springframework.data.mongodb.core.query.Update;

public class ServiceDAO extends DataAccessObject {
	
	public boolean register(String serviceName, String serviceUrl){

		ServiceType map = new ServiceType();
		map.setServiceName(serviceName);
		map.setServiceUrl(serviceUrl);

		if(mongoOps.findOne(query(where("serviceUrl").is(serviceUrl)), ServiceType.class, "Service") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(map, "Service");
		return true;
	}
	
	public String queryKey(String serviceUrl){

		ServiceType map = mongoOps.findOne(query(where("serviceUrl").is(serviceUrl)), ServiceType.class, "Service");

		if(map == null) {
			return null;
		}
		return map.getServiceName();
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

		CheckNumType map = new CheckNumType();
		map.setType("service");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("service")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("service")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}

}
