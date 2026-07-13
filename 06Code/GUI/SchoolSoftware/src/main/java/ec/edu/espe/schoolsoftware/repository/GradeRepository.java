/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Grade;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class GradeRepository extends BaseRepository implements ICrudOperations<Grade> {

    private final MongoCollection<Document> collection;

    public GradeRepository() {
        collection = getCollection("grades");
    }

    @Override
    public void save(Grade grade) {
        Document document = new Document()
                .append("_id", grade.getId())
                .append("studentId", grade.getStudentId())
                .append("score", grade.getScore())
                .append("feedback", grade.getFeedback());

        collection.insertOne(document);
    }

    @Override
    public ArrayList<Grade> read() {
        ArrayList<Grade> grades = new ArrayList<>();

        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            Grade grade = new Grade(
                    doc.getString("_id"),
                    doc.getString("studentId"),
                    doc.getDouble("score"),
                    doc.getString("feedback")
            );
            grades.add(grade);
        }

        return grades;
    }

    @Override
    public void update(Grade grade) {
        Document update = new Document("$set",
                new Document("studentId", grade.getStudentId())
                        .append("score", grade.getScore())
                        .append("feedback", grade.getFeedback())
        );

        collection.updateOne(Filters.eq("_id", grade.getId()), update);
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Grade findById(String id) {
        Document doc = collection.find(Filters.eq("_id", id)).first();

        if (doc == null) {
            return null;
        }

        return new Grade(
                doc.getString("_id"),
                doc.getString("studentId"),
                doc.getDouble("score"),
                doc.getString("feedback"));
    }

}
