package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.bus.GLNType;
import org.springframework.data.mongodb.core.query.Update;

public class GlnDAO extends DataAccessObject {

	public void register(String objectID, String gln){

		GLNType map = new GLNType();
		map.setObjectID(objectID);
		map.setGln(gln);

		if(mongoOps.findOne(query(where("objectID").is(objectID)), GLNType.class, "GLN") != null || mongoOps.findOne(query(where("gln").is(gln)), GLNType.class, "GLN") != null) {
			System.out.println("duplicate error!");
			return;
		}
		mongoOps.insert(map, "GLN");

	}

	public String queryKey(String objectID){

		GLNType map = mongoOps.findOne(query(where("objectID").is(objectID)), GLNType.class, "GLN");

		if(map == null) {
			return null;
		}
		return map.getGln();
	}

	public List<GLNType> queryAll() {

		List<GLNType> list = mongoOps.findAll(GLNType.class, "GLN");

		return list;
	}
	
	public void update(String objectID, String gln) {

		Update update = new Update();
		update.set("gln", gln);
		mongoOps.updateFirst(query(where("objectID").is(objectID)), update, GLNType.class, "GLN");
	}

	public void delete(String objectID) {

		mongoOps.remove(query(where("objectID").is(objectID)), GLNType.class, "GLN");
	}

	public void putCheckNum(int checkNum) {

		CheckNumType map = new CheckNumType();
		map.setType("gln");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("gln")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("gln")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}
}
