package org.gs1.smartcity.db.mongo;

import org.springframework.data.mongodb.core.MongoOperations;

public abstract class DataAccessObject {
	
	protected MongoOperations mongoOps;

	public DataAccessObject() {

		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();

	}

	public abstract void register(String key, String value);
	public abstract String queryKey(String key);
	public abstract void update(String key, String value);
	public abstract void delete(String key);
	
	public abstract void putCheckNum(int checkNum);
	public abstract int getCheckNum();
}
