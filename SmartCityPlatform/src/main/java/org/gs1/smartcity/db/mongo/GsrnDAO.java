package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoOperations;

public class GsrnDAO extends DataAccessObject {

private MongoOperations mongoOps;
	
	public GsrnDAO() {
		
		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();
		
	}
	
	public void register(String objectID, String GSRN){

		Map<String, String> map = new HashMap<String, String>();
		map.put(objectID, GSRN);

		mongoOps.insert(map, "GSRN");

	}
	
	public String queryKey(String objectID){

		@SuppressWarnings("unchecked")
		Map<String, String> map = mongoOps.findOne(query(where("objectID").is(objectID)), HashMap.class, "GSRN");

		if(map == null) {
			return null;
		}
		return map.get(objectID);
	}
	
}