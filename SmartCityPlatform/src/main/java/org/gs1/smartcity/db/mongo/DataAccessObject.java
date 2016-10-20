package org.gs1.smartcity.db.mongo;

import org.gs1.smartcity.datatype.CheckNumType;
import org.springframework.data.mongodb.core.MongoOperations;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public abstract class DataAccessObject {
	
	protected MongoOperations mongoOps;

	public DataAccessObject() {

		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();

	}

	public abstract void register(String key, String value);
	public abstract String queryKey(String key);
	
	public void putCheckNum(String checkNum) {
		
		CheckNumType map = new CheckNumType();
		map.setStatus("recent");
		map.setCheckNum(checkNum);
		mongoOps.dropCollection("checkNum");
		mongoOps.insert(map, "checkNum");
	}
	
	public String getCheckNum() {
		
		CheckNumType map = mongoOps.findOne(query(where("status").is("recent")), CheckNumType.class, "checkNum");
		
		return map.getCheckNum();
	}
}
