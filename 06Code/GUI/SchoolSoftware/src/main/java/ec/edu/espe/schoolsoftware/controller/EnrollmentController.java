package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Enrollment;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class EnrollmentController implements CrudOperations<Enrollment> {

    @Override
    public void save(Enrollment enrollment) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("enrollments");

        Document document = new Document()
                .append("_id", enrollment.getId())
                .append("courseId", enrollment.getCourseId())
                .append("studentId", enrollment.getStudentId());

        collection.insertOne(document);
    }

    @Override
    public void update(Enrollment enrollment) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("enrollments");

        Document update = new Document("$set",
                new Document("courseId",
                        enrollment.getCourseId())
                        .append("studentId",
                                enrollment.getStudentId()));

        collection.updateOne(
                Filters.eq("_id", enrollment.getId()),
                update);
    }

    @Override
    public void delete(String id) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("enrollments");

        collection.deleteOne(
                Filters.eq("_id", id));
    }

    @Override
    public Enrollment findById(String id) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("enrollments");

        Document doc
                = collection.find(
                        Filters.eq("_id", id))
                        .first();

        if (doc == null) {
            return null;
        }

        return new Enrollment(
                doc.getString("_id"),
                doc.getString("courseId"),
                doc.getString("studentId"));
    }

    public ArrayList<Enrollment> getAllEnrollments() {

        ArrayList<Enrollment> enrollments
                = new ArrayList<>();

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("enrollments");

        FindIterable<Document> documents
                = collection.find();

        for (Document doc : documents) {

            Enrollment enrollment
                    = new Enrollment(
                            doc.getString("_id"),
                            doc.getString("courseId"),
                            doc.getString("studentId"));

            enrollments.add(enrollment);
        }

        return enrollments;
    }

    public boolean enrollStudent(
            String enrollmentId,
            String courseId,
            String studentId) {

        Enrollment enrollment
                = new Enrollment(
                        enrollmentId,
                        courseId,
                        studentId);

        save(enrollment);

        return true;
    }

    public boolean removeStudentFromCourse(
            String enrollmentId) {

        delete(enrollmentId);

        return true;
    }

    public int countStudentsPerCourse(
            String courseId) {

        int count = 0;

        for (Enrollment enrollment
                : getAllEnrollments()) {

            if (enrollment.getCourseId()
                    .equals(courseId)) {

                count++;

            }
        }

        return count;
    }
}
