package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoOperations;

public class ComapnyPrefixDAO extends DataAccessObject {

	private MongoOperations mongoOps;

	public ComapnyPrefixDAO() {

		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();

	}

	public void register(String company, String prefix){

		Map<String, String> map = new HashMap<String, String>();
		map.put(company, prefix);

		mongoOps.insert(map, "companyPrefix");
	}

	public String queryKey(String company){

		@SuppressWarnings("unchecked")
		Map<String, String> map = mongoOps.findOne(query(where("company").is(company)), HashMap.class, "companyPrefix");

		if(map == null) {
			return null;
		}
		return map.get(company);
	}

}
