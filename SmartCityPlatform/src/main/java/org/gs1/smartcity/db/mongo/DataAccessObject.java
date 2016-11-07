package org.gs1.smartcity.db.mongo;

import org.springframework.data.mongodb.core.MongoOperations;

public abstract class DataAccessObject {
	
	protected MongoOperations mongoOps;

	public DataAccessObject() {

		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();

	}

	public abstract boolean register(String key, String value);
	public abstract String queryKey(String key);
	public abstract boolean update(String key, String value);
	public abstract boolean delete(String key);
	
	public abstract boolean putCheckNum(int checkNum);
	public abstract int getCheckNum();
}
