package org.gs1.smartcity.db.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.bus.CompanyPrefixType;

public class ComapnyPrefixDAO extends DataAccessObject {

	public void register(String companyName, String companyPrefix){

		CompanyPrefixType map = new CompanyPrefixType();
		map.setCompanyName(companyName);
		map.setCompanyPrefix(companyPrefix);

		mongoOps.insert(map, "companyPrefix");
	}

	public String queryKey(String companyName){

		CompanyPrefixType map = mongoOps.findOne(query(where("companyName").is(companyName)), CompanyPrefixType.class, "companyPrefix");

		
		if(map == null) {
			return null;
		}
		return map.getCompanyPrefix();
	}

}
