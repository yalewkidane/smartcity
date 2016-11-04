package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.ServiceClassType;
import org.springframework.data.mongodb.core.query.Update;

public class ServiceClassDAO extends DataAccessObject {

	public void register(String serviceUrl, String serviceID){

		ServiceClassType map = new ServiceClassType();
		map.setServiceUrl(serviceUrl);
		map.setServiceID(serviceID);

		if(mongoOps.findOne(query(where("serviceUrl").is(serviceUrl)), ServiceClassType.class, "ServiceClass") != null) {
			System.out.println("duplicate error!");
			return;
		}
		mongoOps.insert(map, "ServiceClass");
	}
	
	public String queryKey(String serviceUrl){

		ServiceClassType map = mongoOps.findOne(query(where("serviceUrl").is(serviceUrl)), ServiceClassType.class, "ServiceClass");

		if(map == null) {
			return null;
		}
		return map.getServiceID();
	}
	
	public void update(String serviceUrl, String serviceID) {

		Update update = new Update();
		update.set("serviceID", serviceID);
		mongoOps.updateFirst(query(where("serviceUrl").is(serviceUrl)), update, ServiceClassType.class, "ServiceClass");
	}

	public void delete(String serviceUrl) {

		mongoOps.remove(query(where("serviceUrl").is(serviceUrl)), ServiceClassType.class, "ServiceClass");
	}

	public void putCheckNum(int checkNum) {

		CheckNumType map = new CheckNumType();
		map.setType("serviceClass");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("serviceClass")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("serviceClass")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}
}
