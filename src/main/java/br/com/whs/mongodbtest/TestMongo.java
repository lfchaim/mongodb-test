package br.com.whs.mongodbtest;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.whs.mongodbtest.dbutil.DBUtil;

public class TestMongo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mc = DBUtil.getMongoClient();
		MongoDatabase db = mc.getDatabase("escola");
		MongoCollection<Document> professores = db.getCollection("professores");
		List<Document> list = professores.find().into(new ArrayList<Document>());
		for( Document doc : list ) {
			System.out.println(doc.toJson());
		}
	}

}
