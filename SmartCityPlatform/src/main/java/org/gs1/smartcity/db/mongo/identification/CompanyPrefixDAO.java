package org.gs1.smartcity.db.mongo.identification;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.gs1.smartcity.datatype.CheckNumType;
import org.gs1.smartcity.datatype.identification.CompanyPrefixType;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.springframework.data.mongodb.core.query.Update;

public class CompanyPrefixDAO extends DataAccessObject {

	public boolean register(String companyID, String companyPrefix){

		CompanyPrefixType company = new CompanyPrefixType();
		company.setCompanyID(companyID);
		company.setCompanyPrefix(companyPrefix);

		if(mongoOps.findOne(query(where("companyID").is(companyID)), CompanyPrefixType.class, "CompanyPrefix") != null || mongoOps.findOne(query(where("companyPrefix").is(companyPrefix)), CompanyPrefixType.class, "CompanyPrefix") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(company, "CompanyPrefix");
		return true;
	}

	public String queryKey(String companyID){

		CompanyPrefixType company = mongoOps.findOne(query(where("companyID").is(companyID)), CompanyPrefixType.class, "CompanyPrefix");

		
		if(company == null) {
			return null;
		}
		return company.getCompanyPrefix();
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

		CheckNumType company = new CheckNumType();
		company.setType("companyPrefix");
		company.setCheckNum(checkNum);

		mongoOps.remove(query(where("type").is("companyPrefix")), CheckNumType.class, "CheckNum");
		mongoOps.insert(company, "CheckNum");
		
		return true;
	}

	public int getCheckNum() {

		CheckNumType company = mongoOps.findOne(query(where("type").is("companyPrefix")), CheckNumType.class, "CheckNum");

		return company.getCheckNum();
	}
}
