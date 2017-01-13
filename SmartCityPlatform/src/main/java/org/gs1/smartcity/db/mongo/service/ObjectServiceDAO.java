package org.gs1.smartcity.db.mongo.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.service.ObejctServiceType;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.springframework.data.mongodb.core.query.Update;

public class ObjectServiceDAO extends DataAccessObject {

	public boolean register(String objectID, String serviceID){

		ObejctServiceType objectService = new ObejctServiceType();
		objectService.setObjectID(objectID);
		objectService.setServiceID(serviceID);

		if(mongoOps.findOne(query(where("objectID").is(objectID)), ObejctServiceType.class, "ObjectService") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(objectService, "ObjectService");
		return true;
	}
	
	public String queryKey(String objectID){

		ObejctServiceType objectService = mongoOps.findOne(query(where("objectID").is(objectID)), ObejctServiceType.class, "ObjectService");

		if(objectService == null) {
			return null;
		}
		return objectService.getServiceID();
	}
	
	public boolean update(String objectID, String serviceID) {

		Update update = new Update();
		update.set("serviceID", serviceID);
		mongoOps.updateFirst(query(where("objectID").is(objectID)), update, ObejctServiceType.class, "ObjectService");
		
		return true;
	}

	public boolean delete(String objectID) {

		mongoOps.remove(query(where("objectID").is(objectID)), ObejctServiceType.class, "ObjectService");
		
		return true;
	}

	public boolean putCheckNum(int checkNum) {

		CheckNumType objectService = new CheckNumType();
		objectService.setType("objectService");
		objectService.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("objectService")), CheckNumType.class, "CheckNum");
		mongoOps.insert(objectService, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType objectService = mongoOps.findOne(query(where("type").is("objectService")), CheckNumType.class, "CheckNum");

		return objectService.getCheckNum();
	}
}
