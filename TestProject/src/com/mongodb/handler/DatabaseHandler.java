package com.mongodb.handler;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseHandler {

	private static MongoClient client;
	private static MongoDatabase database;
	private static DatabaseHandler DB_HANDLER;

	public static DatabaseHandler getInstance() {
		if (DB_HANDLER == null) {
			synchronized (DatabaseHandler.class) {
				DB_HANDLER = new DatabaseHandler();
				init();
			}
		}
		return DB_HANDLER;
	}

	private static void init() {
		if (client == null && database == null) {
			client = new MongoClient("localhost", 27017);
			database = client.getDatabase("MASTER_DB");
		}
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public MongoCollection<Document> getCollection(String collectionName) {
		return database.getCollection(collectionName);
	}

	public void addDocuments() {
		
		MongoCollection<Document> collection = getCollection("EMPLOYEE");
		Document document = new Document("employee_id", "as1ire").append("employee_name", "Adam Scott").append("employee_number", 0001)
				.append("employee_level", "level_3");
		collection.insertOne(document);
	}
}
