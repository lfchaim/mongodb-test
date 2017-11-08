package br.com.whs.mongodbtest.dbutil;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBUtil {

	public static MongoClient getMongoClient() {
		MongoClient mc = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		return mc;
	}
	
	public static List<Document> listCollection( String dbName, String collectName ){
		MongoClient mc = getMongoClient();
		MongoDatabase db = mc.getDatabase(dbName);
		MongoCollection<Document> collDoc = db.getCollection(collectName);
		List<Document> list = collDoc.find().into(new ArrayList<Document>());
		return list;
	}
	
	public static MongoCollection<Document> getMongoCollection( String dbName, String collectName ){
		MongoClient mc = getMongoClient();
		MongoDatabase db = mc.getDatabase(dbName);
		MongoCollection<Document> collDoc = db.getCollection(collectName);
		return collDoc;
	}
	
	public static boolean insertOne( String dbName, String collectName, Document document ) {
		try {
			MongoClient mc = getMongoClient();
			MongoDatabase db = mc.getDatabase(dbName);
			MongoCollection<Document> collDoc = db.getCollection(collectName);
			collDoc.insertOne(document);
		}catch( Exception e ) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean deleteOne( String dbName, String collectName, Document document ) {
		try {
			MongoClient mc = getMongoClient();
			MongoDatabase db = mc.getDatabase(dbName);
			MongoCollection<Document> collDoc = db.getCollection(collectName);
			collDoc.deleteOne(document);
		}catch( Exception e ) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
