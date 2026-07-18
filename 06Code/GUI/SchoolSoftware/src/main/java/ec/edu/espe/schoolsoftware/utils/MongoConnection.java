/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class MongoConnection {
    private static MongoConnection instance;

    private MongoClient client;
    private MongoDatabase database;

    private MongoConnection() {

        Configuration configuration = new Configuration();

        client = MongoClients.create(configuration.getUri());

        database = client.getDatabase(configuration.getDatabase());

        System.out.println("Connected to MongoDB");
    }

    public static MongoConnection getInstance() {

        if (instance == null) {
            instance = new MongoConnection();
        }

        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
