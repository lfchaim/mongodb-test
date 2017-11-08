package br.com.whs.mongodbtest;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import br.com.whs.mongodbtest.dbutil.DBUtil;

public class TestMongo {

	public static void main(String[] args) {
		//insertTest();
		deleteTest();
		listTest();
	}

	private static void listTest() {
		List<Document> list = DBUtil.listCollection("escola", "professores");
		for( Document doc : list ) {
			System.out.println(doc.toJson());
		}
	}
	
	private static void insertTest() {
		Document docDetail = new Document();
		docDetail.put("name", "Jason");
		docDetail.put("idade", 47);
		List<String> disc = new ArrayList<String>();
		disc.add("Matemática");
		disc.add("Estatística");
		docDetail.put("disciplinas", disc);
		docDetail.put("sexo", "m");
		DBUtil.insertOne("escola", "professores", docDetail);
	}
	
	private static void deleteTest() {
		try {
			MongoCollection<Document> mc = DBUtil.getMongoCollection("escola", "professores");
			FindIterable<Document> fi = mc.find(Filters.eq("_id", new ObjectId("5a031b7c36384a5ca8525dce")));
			MongoCursor<Document> curs = fi.iterator();
			while( curs.hasNext() ) {
				Document doc = curs.next();
				System.out.println(doc);
				if( doc.getObjectId("_id").equals(new ObjectId("5a031b3736384a5c569bde8d")) )
					mc.deleteOne(doc);
					
			}
			//DeleteResult dr = mc.deleteOne(new Document("_id","5a031b3736384a5c569bde8d"));
			//System.out.println(dr);
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
