/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.schoolsoftware.model.User;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class UserController {

    public void save(User user) {

        MongoDatabase database = MongoConnection.getDatabase();

        MongoCollection<Document> collection = database.getCollection("users");

        Document document = new Document()
                .append("_id", user.getUsername())
                .append("password", user.getPassword())
                .append("role", user.getRole());

        collection.insertOne(document);
    }
}
