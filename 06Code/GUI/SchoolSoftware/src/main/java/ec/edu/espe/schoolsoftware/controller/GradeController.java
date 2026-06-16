package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Grade;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class GradeController implements CrudOperations<Grade> {

    @Override
    public void save(Grade grade) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("grades");

        Document document = new Document()
                .append("_id", grade.getId())
                .append("studentId", grade.getStudentId())
                .append("score", grade.getScore())
                .append("feedback", grade.getFeedback());

        collection.insertOne(document);
    }

    @Override
    public void update(Grade grade) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("grades");

        Document update = new Document("$set",
                new Document("studentId",
                        grade.getStudentId())
                        .append("score",
                                grade.getScore())
                        .append("feedback",
                                grade.getFeedback()));

        collection.updateOne(
                Filters.eq("_id", grade.getId()),
                update);
    }

    @Override
    public void delete(String id) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("grades");

        collection.deleteOne(
                Filters.eq("_id", id));
    }

    @Override
    public Grade findById(String id) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("grades");

        Document doc
                = collection.find(
                        Filters.eq("_id", id))
                        .first();

        if (doc == null) {
            return null;
        }

        return new Grade(
                doc.getString("_id"),
                doc.getString("studentId"),
                doc.getDouble("score"),
                doc.getString("feedback"));
    }

    public ArrayList<Grade> getAllGrades() {

        ArrayList<Grade> grades
                = new ArrayList<>();

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("grades");

        FindIterable<Document> documents
                = collection.find();

        for (Document doc : documents) {

            Grade grade = new Grade(
                    doc.getString("_id"),
                    doc.getString("studentId"),
                    doc.getDouble("score"),
                    doc.getString("feedback"));

            grades.add(grade);
        }

        return grades;
    }

    public boolean assignGrade(
            Grade grade) {

        save(grade);

        return true;
    }

    public double calculateAverageGrade() {

        ArrayList<Grade> grades
                = getAllGrades();

        double total = 0;

        for (Grade grade : grades) {

            total += grade.getScore();

        }

        return grades.isEmpty()
                ? 0
                : total / grades.size();
    }

    public boolean detectLowPerformance(
            String studentId) {

        ArrayList<Grade> grades
                = getAllGrades();

        double total = 0;
        int count = 0;

        for (Grade grade : grades) {

            if (grade.getStudentId()
                    .equals(studentId)) {

                total += grade.getScore();
                count++;

            }
        }

        if (count == 0) {
            return false;
        }

        return total / count < 70;
    }

    public void generateFeedback(
            String gradeId) {

        Grade grade
                = findById(gradeId);

        String feedback;

        if (grade.getScore() >= 90) {

            feedback
                    = "Excellent performance";

        } else if (grade.getScore() >= 70) {

            feedback
                    = "Good performance";

        } else {

            feedback
                    = "Needs improvement";

        }

        grade.setFeedback(feedback);

        update(grade);
    }
}
