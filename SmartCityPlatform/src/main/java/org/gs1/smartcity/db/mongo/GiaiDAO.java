package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashMap;

import org.springframework.data.mongodb.core.MongoOperations;

public class GiaiDAO extends DataAccessObject {

	private MongoOperations mongoOps;
	
	public GiaiDAO() {
		
		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();
		
	}
	
	public void register(String objectID, String GIAI){

		HashMap<String, String> map = new HashMap<String, String>();
		map.put(objectID, GIAI);

		mongoOps.insert(map, "GIAI");

	}
	
	public String queryKey(String objectID){

		@SuppressWarnings("unchecked")
		HashMap<String, String> map = mongoOps.findOne(query(where("objectID").is(objectID)), HashMap.class, "GIAI");

		if(map == null) {
			return null;
		}
		return map.get(objectID);
	}
	
}
