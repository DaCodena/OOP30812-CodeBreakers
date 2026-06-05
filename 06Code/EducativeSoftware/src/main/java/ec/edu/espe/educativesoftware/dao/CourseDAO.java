/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.educativesoftware.model.Course;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class CourseDAO {

    private final MongoCollection<Document> collection;

    public CourseDAO() {

        MongoDatabase database
                = MongoConnection.getDatabase();

        collection
                = database.getCollection("courses");
    }

    public void save(Course course) {

        Document document = new Document();

        document.append("courseId",
                course.getCourseId());

        document.append("name",
                course.getName());

        document.append("subject",
                course.getSubject());

        document.append("description",
                course.getDescription());

        collection.insertOne(document);
    }

    public List<Course> findAll() {

        List<Course> courses
                = new ArrayList<>();

        for (Document document : collection.find()) {

            Course course
                    = new Course();

            course.setCourseId(
                    document.getString("courseId"));

            course.setName(
                    document.getString("name"));

            course.setSubject(
                    document.getString("subject"));

            course.setDescription(
                    document.getString("description"));

            courses.add(course);
        }

        return courses;
    }

}
