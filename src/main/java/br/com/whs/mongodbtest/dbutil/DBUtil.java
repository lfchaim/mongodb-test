package br.com.whs.mongodbtest.dbutil;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DBUtil {

	public static MongoClient getMongoClient() {
		MongoClient mc = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		return mc;
	}
}
