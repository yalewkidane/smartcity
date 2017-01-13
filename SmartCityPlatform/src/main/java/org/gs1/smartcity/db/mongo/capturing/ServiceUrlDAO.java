package org.gs1.smartcity.db.mongo.capturing;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.datatype.url.ServiceUrlDetailType;
import org.gs1.smartcity.datatype.url.ServiceUrlType;
import org.gs1.smartcity.db.mongo.MongoInstance;
import org.springframework.data.mongodb.core.MongoOperations;

public class ServiceUrlDAO {

	protected MongoOperations mongoOps;

	public ServiceUrlDAO() {

		MongoInstance mongo = MongoInstance.getInstance();
		mongoOps = mongo.getMongoOps();

	}

	public boolean registerServiceName(String serviceName, String baseUrl) {

		ServiceUrlType service = new ServiceUrlType();
		service.setServiceName(serviceName);
		service.setBaseUrl(baseUrl);

		if(mongoOps.findOne(query(where("serviceName").is(serviceName)), ServiceUrlType.class, "ServiceUrl") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(service, "ServiceUrl");
		return true;
	}

	public boolean registerInfoType(String serviceName, String infoType, String infoUrl, int numOfParams) {

		ServiceUrlDetailType service = new ServiceUrlDetailType();
		service.setServiceName(serviceName);
		service.setInfoType(infoType);
		service.setInfoUrl(infoUrl);
		service.setNumOfParams(numOfParams);

		if(mongoOps.findOne(query(where("serviceName").is(serviceName).and("infoType").is(infoType)), ServiceUrlDetailType.class, "ServiceUrlDetail") != null) {
			System.out.println("duplicate error!");
			return false;
		}
		mongoOps.insert(service, "ServiceUrlDetail");
		return true;
	}

	public String queryServiceName(String serviceName) {

		ServiceUrlType service = mongoOps.findOne(query(where("serviceName").is(serviceName)), ServiceUrlType.class, "ServiceUrl");

		if(service == null) {
			return null;
		}
		return service.getBaseUrl();
	}

	public ServiceUrlDetailType queryInfoType(String serviceName, String infoType) {

		ServiceUrlDetailType service = mongoOps.findOne(query(where("serviceName").is(serviceName).and("infoType").is(infoType)), ServiceUrlDetailType.class, "ServiceUrlDetail");

		return service;
	}

	public boolean deleteServiceName(String serviceName) {

		mongoOps.remove(query(where("serviceName").is(serviceName)), ServiceUrlType.class, "ServiceUrl");

		return true;
	}

	public boolean deleteInfoType(String serviceName, String infoType) {

		mongoOps.remove(query(where("serviceName").is(serviceName).and("infoType").is(infoType)), ServiceUrlDetailType.class, "ServiceUrlDatail");

		return true;
	}
}
