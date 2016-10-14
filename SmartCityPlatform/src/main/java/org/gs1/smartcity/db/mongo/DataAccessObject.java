package org.gs1.smartcity.db.mongo;

public abstract class DataAccessObject {

	public abstract void register(String key, String value);
	public abstract String queryKey(String key);
}
