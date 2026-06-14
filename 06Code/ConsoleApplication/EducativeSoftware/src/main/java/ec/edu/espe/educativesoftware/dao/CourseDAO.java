/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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

        document.append(
                "courseId",
                course.getCourseId());

        document.append(
                "name",
                course.getName());

        document.append(
                "subject",
                course.getSubject());

        document.append(
                "description",
                course.getDescription());

        document.append(
                "teacher",
                course.getTeacher());

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

            course.setTeacher(
                    document.getString("teacher"));

            courses.add(course);
        }

        return courses;
    }

    public Course findById(String courseId) {

        Document document
                = collection.find(
                        Filters.eq(
                                "courseId",
                                courseId))
                        .first();

        if (document == null) {
            return null;
        }

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

        course.setTeacher(
                document.getString("teacher"));

        return course;
    }

    public void update(Course course) {

        Document updatedCourse
                = new Document()
                        .append(
                                "name",
                                course.getName())
                        .append(
                                "subject",
                                course.getSubject())
                        .append(
                                "description",
                                course.getDescription())
                        .append(
                                "teacher",
                                course.getTeacher());

        collection.updateOne(
                Filters.eq(
                        "courseId",
                        course.getCourseId()),
                new Document(
                        "$set",
                        updatedCourse)
        );
    }

    public void delete(String courseId) {

        collection.deleteOne(
                Filters.eq(
                        "courseId",
                        courseId)
        );
    }

    public List<Course> search(
            String name,
            String subject,
            String teacher) {

        List<Course> courses
                = findAll();

        List<Course> results
                = new ArrayList<>();

        for (Course course : courses) {

            boolean matches = true;

            if (!name.isBlank()) {

                matches &= course
                        .getName()
                        .toLowerCase()
                        .contains(
                                name.toLowerCase());
            }

            if (!subject.isBlank()) {

                matches &= course
                        .getSubject()
                        .toLowerCase()
                        .contains(
                                subject.toLowerCase());
            }

            if (!teacher.equals("-")) {

                matches &= course
                        .getTeacher()
                        .equalsIgnoreCase(
                                teacher);
            }

            if (matches) {

                results.add(course);
            }
        }

        return results;
    }
}
