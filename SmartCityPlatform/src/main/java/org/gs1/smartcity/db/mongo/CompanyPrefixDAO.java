package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.bus.CompanyPrefixType;
import org.springframework.data.mongodb.core.query.Update;

public class CompanyPrefixDAO extends DataAccessObject {

	public boolean register(String companyID, String companyPrefix){

		CompanyPrefixType map = new CompanyPrefixType();
		map.setCompanyID(companyID);
		map.setCompanyPrefix(companyPrefix);

		if(mongoOps.findOne(query(where("companyID").is(companyID)), CompanyPrefixType.class, "CompanyPrefix") != null || mongoOps.findOne(query(where("companyPrefix").is(companyPrefix)), CompanyPrefixType.class, "CompanyPrefix") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(map, "CompanyPrefix");
		return true;
	}

	public String queryKey(String companyID){

		CompanyPrefixType map = mongoOps.findOne(query(where("companyID").is(companyID)), CompanyPrefixType.class, "CompanyPrefix");

		
		if(map == null) {
			return null;
		}
		return map.getCompanyPrefix();
	}
	
	public List<CompanyPrefixType> queryAll() {

		List<CompanyPrefixType> list = mongoOps.findAll(CompanyPrefixType.class, "CompanyPrefix");

		return list;
	}

	public boolean update(String companyID, String companyPrefix) {

		Update update = new Update();
		update.set("companyPrefix", companyPrefix);
		mongoOps.updateFirst(query(where("companyID").is(companyID)), update, CompanyPrefixType.class, "CompanyPrefix");
		
		return true;
	}

	public boolean delete(String companyID) {

		mongoOps.remove(query(where("companyID").is(companyID)), CompanyPrefixType.class, "CompanyPrefix");
		
		return true;
	}

	public boolean putCheckNum(int checkNum) {

		CheckNumType map = new CheckNumType();
		map.setType("companyPrefix");
		map.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("companyPrefix")), CheckNumType.class, "CheckNum");
		mongoOps.insert(map, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType map = mongoOps.findOne(query(where("type").is("companyPrefix")), CheckNumType.class, "CheckNum");

		return map.getCheckNum();
	}
}
