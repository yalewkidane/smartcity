package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.bus.GIAIType;
import org.springframework.data.mongodb.core.query.Update;

public class GiaiDAO extends DataAccessObject {

	public boolean register(String objectID, String giai){

		GIAIType map = new GIAIType();
		map.setObjectID(objectID);
		map.setGiai(giai);

		if(mongoOps.findOne(query(where("objectID").is(objectID)), GIAIType.class, "GIAI") != null || mongoOps.findOne(query(where("giai").is(giai)), GIAIType.class, "GIAI") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(map, "GIAI");
		return true;
	}

	public String queryKey(String objectID){

		GIAIType map = mongoOps.findOne(query(where("objectID").is(objectID)), GIAIType.class, "GIAI");

		if(map == null) {
			return null;
		}
		return map.getGiai();
	}

	public List<GIAIType> queryAll() {

		List<GIAIType> list = mongoOps.findAll(GIAIType.class, "GIAI");

		return list;
	}

	public boolean update(String objectID, String giai) {

		Update update = new Update();
		update.set("giai", giai);
		mongoOps.updateFirst(query(where("objectID").is(objectID)), update, GIAIType.class, "GIAI");
		
		return true;
	}

	public boolean delete(String objectID) {

		mongoOps.remove(query(where("objectID").is(objectID)), GIAIType.class, "GIAI");
		
		return true;
	}

	public boolean putCheckNum(int checkNum) {

		CheckNumType map = new CheckNumType();
		map.setType("giai");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("giai")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("giai")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}

}
