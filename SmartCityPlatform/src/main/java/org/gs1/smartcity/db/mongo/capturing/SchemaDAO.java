package org.gs1.smartcity.db.mongo.capturing;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.gs1.smartcity.datatype.MatchingSchemeType;
import org.gs1.smartcity.datatype.SchemeValueType;
import org.gs1.smartcity.db.mongo.MongoInstance;
import org.springframework.data.mongodb.core.MongoOperations;

public class SchemaDAO {
	
	protected MongoOperations mongoOps;

	public SchemaDAO() {

		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();

	}
	
	public boolean registerSchema(String serviceName, String infoType, List<SchemeValueType> schemeList) {
		
		MatchingSchemeType matchingScheme = new MatchingSchemeType();
		matchingScheme.setServiceName(serviceName);
		matchingScheme.setInfoType(infoType);
		matchingScheme.getSchemeList().addAll(schemeList);
		
		if(mongoOps.findOne(query(where("serviceName").is(serviceName).and("infoType").is(infoType)), MatchingSchemeType.class, "MatchingScheme") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(matchingScheme, "MatchingScheme");
		return true;
	}
	
	public List<SchemeValueType> querySchemeList(String serviceName, String infoType) {
		
		MatchingSchemeType matchingScheme = mongoOps.findOne(query(where("serviceName").is(serviceName).and("infoType").is(infoType)), MatchingSchemeType.class, "MatchingScheme");
		
		return matchingScheme.getSchemeList();
	}

}
