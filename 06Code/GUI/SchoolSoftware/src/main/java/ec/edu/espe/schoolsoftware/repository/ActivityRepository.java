/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Activity;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class ActivityRepository extends BaseRepository implements ICrudOperations<Activity>{
   
    private final MongoCollection<Document> collection;

    public ActivityRepository(){
        collection = getCollection("activities");
    }
    
    @Override
    public void save(Activity activity) {
        Document document = new Document()
                .append("_id", activity.getId())
                .append("courseId", activity.getCourseId())
                .append("title", activity.getTitle());

        collection.insertOne(document);
    }

    @Override
    public ArrayList<Activity> read() {
        ArrayList<Activity> activities = new ArrayList<>();

        FindIterable<Document> docs = collection.find();

        for (Document doc : docs) {
            activities.add(new Activity(
                            doc.getString("_id"),
                            doc.getString("courseId"),
                            doc.getString("title")));
        }

        return activities;
    }

    @Override
    public void update(Activity activity) {
        Document update = new Document("$set",
                new Document("courseId", activity.getCourseId())
                        .append("title", activity.getTitle()));

        collection.updateOne(Filters.eq("_id",activity.getId()), update);
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Activity findById(String id) {
        Document doc = collection.find(Filters.eq("_id", id)).first();

        if (doc == null) {
            return null;
        }

        return new Activity(
                doc.getString("_id"),
                doc.getString("courseId"),
                doc.getString("title"));
    }
    
}
