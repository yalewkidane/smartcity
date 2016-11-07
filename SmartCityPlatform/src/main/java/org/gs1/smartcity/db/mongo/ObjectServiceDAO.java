package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.ObejctServiceType;
import org.springframework.data.mongodb.core.query.Update;

public class ObjectServiceDAO extends DataAccessObject {

	public boolean register(String objectID, String serviceID){

		ObejctServiceType map = new ObejctServiceType();
		map.setObjectID(objectID);
		map.setServiceID(serviceID);

		if(mongoOps.findOne(query(where("objectID").is(objectID)), ObejctServiceType.class, "ObjectService") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(map, "ObjectService");
		return true;
	}
	
	public String queryKey(String objectID){

		ObejctServiceType map = mongoOps.findOne(query(where("objectID").is(objectID)), ObejctServiceType.class, "ObjectService");

		if(map == null) {
			return null;
		}
		return map.getServiceID();
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

		CheckNumType map = new CheckNumType();
		map.setType("objectService");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("objectService")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("objectService")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}
}
