/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Enrollment;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class EnrollmentRepository extends BaseRepository implements ICrudOperations<Enrollment> {
    private final MongoCollection<Document> collection;

    public EnrollmentRepository() {
        collection = getCollection("enrollments");
    }
    @Override
    public void save(Enrollment enrollment) {
        Document document = new Document()
                .append("_id", enrollment.getId())
                .append("courseId", enrollment.getCourseId())
                .append("studentId", enrollment.getStudentId());

        collection.insertOne(document);
    }

    @Override
    public ArrayList<Enrollment> read() {
        ArrayList<Enrollment> enrollments
                = new ArrayList<>();

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

    @Override
    public void update(Enrollment enrollment) {
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
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Enrollment findById(String id) {
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
    
}
