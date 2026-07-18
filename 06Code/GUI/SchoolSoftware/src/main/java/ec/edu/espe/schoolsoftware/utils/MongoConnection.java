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
    private static final String URI =
            "mongodb+srv://daniel:daniel1234@cluster0.zfwd5wx.mongodb.net/?appName=Cluster0";

    private static final String DATABASE = "EducationalApp";
    private static MongoConnection instance;

    private MongoClient client;
    private MongoDatabase database;
    private MongoConnection() {
        client = MongoClients.create(URI);
        database = client.getDatabase(DATABASE);
    }
    public static synchronized MongoConnection getInstance() {
        if (instance == null) {
            instance = new MongoConnection();
        }
        return instance;
    }
    public MongoDatabase getDatabase() {
        return database;
    }
}
