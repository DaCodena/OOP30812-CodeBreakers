/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.model.User;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Session;
import org.bson.Document;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class LoginController {

    public User login(String username, String password) {

        MongoDatabase database = MongoConnection.getInstance().getDatabase();

        MongoCollection<Document> collection = database.getCollection("users");

        Document doc = collection.find(
                Filters.and(
                        Filters.eq("_id", username),
                        Filters.eq("password", password)
                )
        ).first();

        if (doc == null) {
            return null;
        }

        User user = new User(doc.getString("_id"), doc.getString("password"), doc.getString("role"));

        return user;
    }

    public void logout() {
        Session.setCurrentUser(null);
    }
}
