package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.ServiceType;
import org.springframework.data.mongodb.core.query.Update;

public class ServiceDAO extends DataAccessObject {

	public void register(String objectID, String serviceID){

		ServiceType map = new ServiceType();
		map.setObjectID(objectID);
		map.setServiceID(serviceID);

		if(mongoOps.findOne(query(where("objectID").is(objectID)), ServiceType.class, "Service") != null) {
			System.out.println("duplicate error!");
			return;
		}
		mongoOps.insert(map, "Service");
	}
	
	public String queryKey(String objectID){

		ServiceType map = mongoOps.findOne(query(where("objectID").is(objectID)), ServiceType.class, "Service");

		if(map == null) {
			return null;
		}
		return map.getServiceID();
	}
	
	public void update(String objectID, String serviceID) {

		Update update = new Update();
		update.set("serviceID", serviceID);
		mongoOps.updateFirst(query(where("objectID").is(objectID)), update, ServiceType.class, "Service");
	}

	public void delete(String serviceID) {

		mongoOps.remove(query(where("serviceID").is(serviceID)), ServiceType.class, "Service");
	}

	public void putCheckNum(int checkNum) {

		CheckNumType map = new CheckNumType();
		map.setType("service");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("service")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("service")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}
}
