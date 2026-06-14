/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

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
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class QuizController implements CrudOperations<Quiz> {

    @Override
    public void save(Quiz quiz) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("quizzes");

        Document document = new Document()
                .append("_id", quiz.getId())
                .append("courseId", quiz.getCourseId())
                .append("title", quiz.getTitle());

        collection.insertOne(document);
    }

    @Override
    public void update(Quiz quiz) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("quizzes");

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

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("quizzes");

        collection.deleteOne(
                Filters.eq("_id", id));
    }

    @Override
    public Quiz findById(String id) {

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("quizzes");

        Document doc
                = collection.find(
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

    public ArrayList<Quiz> getAllQuizzes() {

        ArrayList<Quiz> quizzes
                = new ArrayList<>();

        MongoDatabase database
                = MongoConnection.getDatabase();

        MongoCollection<Document> collection
                = database.getCollection("quizzes");

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

    public boolean createQuiz(
            Quiz quiz) {

        save(quiz);

        return true;
    }
}
