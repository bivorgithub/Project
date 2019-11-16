package com.mongodb.handler;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class TestMongoDb {

	public static void main(String[] args) {
		String hashToString = BCrypt.withDefaults().hashToString(12, "blabblab".toCharArray());
		System.out.println(hashToString);
		BCrypt.
//		DatabaseHandler.getInstance().addDocuments();
//		MongoCollection<Document> collection = DatabaseHandler.getInstance().getCollection("EMPLOYEE");
//		FindIterable<Document> find = collection.find();
//		MongoCursor<Document> iterator = find.iterator();
//		while(iterator.hasNext()) {
//			Document document = iterator.next();
//			System.out.println(document.get("employee_name"));
//		}
	}

}
