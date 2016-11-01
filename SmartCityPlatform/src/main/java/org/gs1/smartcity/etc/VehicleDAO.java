package org.gs1.smartcity.etc;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.gs1.smartcity.db.mongo.DataAccessObject;

public class VehicleDAO extends DataAccessObject {
	
	public void register(String vehicleNo, String lineId){

		VehicleType map = new VehicleType();
		map.setVehicleNo(vehicleNo);
		map.setLineId(lineId);

		mongoOps.insert(map, "Vehicle");

	}
	
	public String queryKey(String vehicleNo){

		VehicleType map = mongoOps.findOne(query(where("vehicleNo").is(vehicleNo)), VehicleType.class, "Vehicle");

		if(map == null) {
			return null;
		}
		return map.getLineId();
	}
}
