package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.bus.GLNType;

public class GlnDAO extends DataAccessObject {
	
	public void register(String objectID, String gln){

		GLNType map = new GLNType();
		map.setObjectID(objectID);
		map.setGln(gln);
		
		mongoOps.insert(map, "GLN");

	}
	
	public String queryKey(String objectID){

		GLNType map = mongoOps.findOne(query(where("objectID").is(objectID)), GLNType.class, "GLN");

		if(map == null) {
			return null;
		}
		return map.getGln();
	}

}
