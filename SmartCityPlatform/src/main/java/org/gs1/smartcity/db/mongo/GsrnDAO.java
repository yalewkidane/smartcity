package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.bus.GSRNType;
import org.springframework.data.mongodb.core.query.Update;

public class GsrnDAO extends DataAccessObject {

	public void register(String objectID, String gsrn){

		GSRNType map = new GSRNType();
		map.setObjectID(objectID);
		map.setGsrn(gsrn);

		if(mongoOps.findOne(query(where("objectID").is(objectID)), GSRNType.class, "GSRN") != null || mongoOps.findOne(query(where("gsrn").is(gsrn)), GSRNType.class, "GSRN") != null) {
			System.out.println("duplicate error!");
			return;
		}
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
	
	public void update(String objectID, String gsrn) {

		Update update = new Update();
		update.set("gsrn", gsrn);
		mongoOps.updateFirst(query(where("objectID").is(objectID)), update, GSRNType.class, "GSRN");
	}

	public void delete(String objectID) {

		mongoOps.remove(query(where("objectID").is(objectID)), GSRNType.class, "GSRN");
	}

	public void putCheckNum(int checkNum) {

		CheckNumType map = new CheckNumType();
		map.setType("gsrn");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("gsrn")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("gsrn")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}
}