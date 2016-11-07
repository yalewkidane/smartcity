package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.ServiceClassType;
import org.springframework.data.mongodb.core.query.Update;

public class ServiceClassDAO extends DataAccessObject {

	public boolean register(String serviceID, String serviceName){

		ServiceClassType map = new ServiceClassType();
		map.setServiceID(serviceID);
		map.setServiceName(serviceName);

		if(mongoOps.findOne(query(where("serviceID").is(serviceID)), ServiceClassType.class, "ServiceClass") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(map, "ServiceClass");
		return true;
	}
	
	public String queryKey(String serviceName){

		ServiceClassType map = mongoOps.findOne(query(where("serviceName").is(serviceName)), ServiceClassType.class, "ServiceClass");

		if(map == null) {
			return null;
		}
		return map.getServiceID();
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

		CheckNumType map = new CheckNumType();
		map.setType("serviceClass");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("serviceClass")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("serviceClass")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}
}
