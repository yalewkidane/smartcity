package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.bus.GIAIType;

public class GiaiDAO extends DataAccessObject {

	public void register(String objectID, String giai){

		GIAIType map = new GIAIType();
		map.setObjectID(objectID);
		map.setGiai(giai);

		mongoOps.insert(map, "GIAI");

	}
	
	public String queryKey(String objectID){

		GIAIType map = mongoOps.findOne(query(where("objectID").is(objectID)), GIAIType.class, "GIAI");

		if(map == null) {
			return null;
		}
		return map.getGiai();
	}
	
}
