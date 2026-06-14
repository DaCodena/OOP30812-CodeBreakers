/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

import ec.edu.espe.schoolsoftware.model.Activity;


/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class ActivityController implements CrudOperations<Activity> {

    @Override
    public void save(Activity activity) {

        MongoCollection<Document> collection =
                MongoConnection.getDatabase()
                .getCollection("activities");

        Document document = new Document()
                .append("_id", activity.getId())
                .append("courseId", activity.getCourseId())
                .append("title", activity.getTitle());

        collection.insertOne(document);
    }

    @Override
    public void update(Activity activity) {

        MongoCollection<Document> collection =
                MongoConnection.getDatabase()
                .getCollection("activities");

        Document update = new Document("$set",
                new Document("courseId",
                        activity.getCourseId())
                        .append("title",
                                activity.getTitle()));

        collection.updateOne(
                Filters.eq("_id",
                        activity.getId()),
                update);
    }

    @Override
    public void delete(String id) {

        MongoCollection<Document> collection =
                MongoConnection.getDatabase()
                .getCollection("activities");

        collection.deleteOne(
                Filters.eq("_id", id));
    }

    @Override
    public Activity findById(String id) {

        MongoCollection<Document> collection =
                MongoConnection.getDatabase()
                .getCollection("activities");

        Document doc =
                collection.find(
                        Filters.eq("_id", id))
                        .first();

        if(doc == null){
            return null;
        }

        return new Activity(
                doc.getString("_id"),
                doc.getString("courseId"),
                doc.getString("title"));
    }

    public ArrayList<Activity> getAllActivities(){

        ArrayList<Activity> activities =
                new ArrayList<>();

        MongoCollection<Document> collection =
                MongoConnection.getDatabase()
                .getCollection("activities");

        FindIterable<Document> docs =
                collection.find();

        for(Document doc : docs){

            activities.add(
                    new Activity(
                            doc.getString("_id"),
                            doc.getString("courseId"),
                            doc.getString("title")));
        }

        return activities;
    }
}
