/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Quiz;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class QuizRepository extends BaseRepository implements ICrudOperations<Quiz> {

    private final MongoCollection<Document> collection;

    public QuizRepository() {
        collection = getCollection("quizzes");
    }

    @Override
    public void save(Quiz quiz) {
        Document document = new Document()
                .append("_id", quiz.getId())
                .append("courseId", quiz.getCourseId())
                .append("title", quiz.getTitle());

        collection.insertOne(document);
    }

    @Override
    public ArrayList<Quiz> read() {
        ArrayList<Quiz> quizzes = new ArrayList<>();

        FindIterable<Document> documents
                = collection.find();

        for (Document doc : documents) {

            Quiz quiz = new Quiz(
                    doc.getString("_id"),
                    doc.getString("courseId"),
                    doc.getString("title"));

            quizzes.add(quiz);
        }

        return quizzes;
    }

    @Override
    public void update(Quiz quiz) {
        Document update = new Document("$set",
                new Document("courseId",
                        quiz.getCourseId())
                        .append("title",
                                quiz.getTitle()));

        collection.updateOne(
                Filters.eq("_id", quiz.getId()),
                update);
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Quiz findById(String id) {

        Document doc = collection.find(
                Filters.eq("_id", id))
                .first();

        if (doc == null) {
            return null;
        }

        return new Quiz(
                doc.getString("_id"),
                doc.getString("courseId"),
                doc.getString("title"));
    }
}
