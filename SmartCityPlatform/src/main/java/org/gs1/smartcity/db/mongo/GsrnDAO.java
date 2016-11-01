package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.gs1.smartcity.datatype.bus.GSRNType;

public class GsrnDAO extends DataAccessObject {

	public void register(String objectID, String gsrn){

		GSRNType map = new GSRNType();
		map.setObjectID(objectID);
		map.setGsrn(gsrn);

		mongoOps.insert(map, "GSRN");
	}
	
	public String queryKey(String objectID){

		GSRNType map = mongoOps.findOne(query(where("objectID").is(objectID)), GSRNType.class, "GSRN");

		if(map == null) {
			return null;
		}
		return map.getGsrn();
	}
	
	public List<GSRNType> queryAll() {
		
		List<GSRNType> list = mongoOps.findAll(GSRNType.class, "GSRN");
		
		return list;
	}
	
}