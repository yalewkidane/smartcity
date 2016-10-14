package org.gs1.smartcity.db.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {

	
	public @Bean MongoTemplate mongoTemplate() throws Exception{
		
		String DBname = "SmartCity";
		String DBaddr = "localhost";
		String DBport = "27017";
		
		MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient(DBaddr, Integer.parseInt(DBport)), DBname);
		return mongoTemplate;
		
	}
}
