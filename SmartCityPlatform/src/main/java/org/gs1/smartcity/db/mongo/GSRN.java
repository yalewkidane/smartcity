package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashMap;

import org.springframework.data.mongodb.core.MongoOperations;

public class GSRN {

private MongoOperations mongoOps;
	
	public GSRN() {
		
		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();
		
	}
	
	public void register(String objectID, String GSRN){

		HashMap<String, String> map = new HashMap<String, String>();
		map.put(objectID, GSRN);

		mongoOps.insert(map, "GSRN");

	}
	
	public String queryKey(String objectID){

		@SuppressWarnings("unchecked")
		HashMap<String, String> map = mongoOps.findOne(query(where("objectID").is(objectID)), HashMap.class, "GSRN");

		if(map == null) {
			return null;
		}
		return map.get(objectID);
	}
	
}