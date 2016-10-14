package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashMap;

import org.springframework.data.mongodb.core.MongoOperations;

public class ComapnyPrefix extends DataAccessObject {

	private MongoOperations mongoOps;

	public ComapnyPrefix() {

		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();

	}

	public void register(String company, String prefix){

		HashMap<String, String> map = new HashMap<String, String>();
		map.put(company, prefix);

		mongoOps.insert(map, "companyPrefix");

	}

	public String queryKey(String company){

		@SuppressWarnings("unchecked")
		HashMap<String, String> map = mongoOps.findOne(query(where("company").is(company)), HashMap.class, "companyPrefix");

		if(map == null) {
			return null;
		}
		return map.get(company);
	}

}
