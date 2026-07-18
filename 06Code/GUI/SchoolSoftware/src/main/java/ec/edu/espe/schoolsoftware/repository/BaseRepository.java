/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public abstract class BaseRepository {
    protected MongoDatabase database;

    public BaseRepository() {
        database = MongoConnection.getInstance().getDatabase();
    }
    
    protected MongoCollection<Document> getCollection(String collectionName){
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection;
    }
    
}
