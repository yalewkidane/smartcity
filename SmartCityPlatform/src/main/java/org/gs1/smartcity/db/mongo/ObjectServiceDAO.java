package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.ObejctServiceType;
import org.springframework.data.mongodb.core.query.Update;

public class ObjectServiceDAO extends DataAccessObject {

	public void register(String objectID, String serviceID){

		ObejctServiceType map = new ObejctServiceType();
		map.setObjectID(objectID);
		map.setServiceID(serviceID);

		if(mongoOps.findOne(query(where("objectID").is(objectID)), ObejctServiceType.class, "Service") != null) {
			System.out.println("duplicate error!");
			return;
		}
		mongoOps.insert(map, "Service");
	}
	
	public String queryKey(String objectID){

		ObejctServiceType map = mongoOps.findOne(query(where("objectID").is(objectID)), ObejctServiceType.class, "Service");

		if(map == null) {
			return null;
		}
		return map.getServiceID();
	}
	
	public void update(String objectID, String serviceID) {

		Update update = new Update();
		update.set("serviceID", serviceID);
		mongoOps.updateFirst(query(where("objectID").is(objectID)), update, ObejctServiceType.class, "Service");
	}

	public void delete(String objectID) {

		mongoOps.remove(query(where("objectID").is(objectID)), ObejctServiceType.class, "Service");
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
