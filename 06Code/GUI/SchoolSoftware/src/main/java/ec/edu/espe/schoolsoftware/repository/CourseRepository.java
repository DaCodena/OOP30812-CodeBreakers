/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Course;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class CourseRepository extends BaseRepository implements ICrudOperations<Course>, IFindByName<Course>{
    private final MongoCollection<Document> collection;

    public CourseRepository(){
        collection = getCollection("courses");
    }
    
    @Override
    public void save(Course course) {
        Document document = new Document()
                .append("_id", course.getId())
                .append("name", course.getName())
                .append("teacherId", course.getTeacherId());

        collection.insertOne(document);
    }

    @Override
    public ArrayList<Course> read() {

        ArrayList<Course> courses = new ArrayList<>();
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            Course course = new Course(
                    doc.getString("_id"),
                    doc.getString("name"),
                    doc.getString("teacherId")
            );
            courses.add(course);
        }

        return courses;
    }

    @Override
    public void update(Course course) {
        Document update = new Document("$set",
                new Document("name", course.getName())
                        .append("teacherId", course.getTeacherId())
        );

        collection.updateOne(Filters.eq("_id", course.getId()), update);
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Course findById(String id) {
        Document doc = collection.find(Filters.eq("_id", id)).first();

        if (doc == null) {
            return null;
        }

        Course course = new Course(
                doc.getString("_id"),
                doc.getString("name"),
                doc.getString("teacherId")
        );

        return course;
    }

    @Override
    public ArrayList<Course> findByName(String name) {
        ArrayList<Course> courses = new ArrayList<>();

        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        FindIterable<Document> documents = collection.find(Filters.regex("name", pattern));

        for (Document doc : documents) {
            courses.add(
                    new Course(
                            doc.getString("_id"), 
                            doc.getString("name"), 
                            doc.getString("teacherId")
                    )
            );
        }
        return courses;
    }
    
}
