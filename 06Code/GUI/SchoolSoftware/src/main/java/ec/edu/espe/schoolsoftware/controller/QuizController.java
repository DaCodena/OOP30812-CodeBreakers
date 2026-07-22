/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Course;
import ec.edu.espe.schoolsoftware.model.Quiz;
import ec.edu.espe.schoolsoftware.repository.ICrudOperations;
import ec.edu.espe.schoolsoftware.repository.QuizRepository;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class QuizController implements ICreate<Quiz> {

    private ICrudOperations<Quiz> quizRepository;

    public QuizController(ICrudOperations<Quiz> quizRepository) {
        this.quizRepository = quizRepository;
    }
    
    public QuizController() {
        
    }

    @Override
    public Quiz create(Course course) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ICrudOperations<Quiz> getQuizRepository() {
        return quizRepository;
    }

    public void setQuizRepository(ICrudOperations<Quiz> quizRepository) {
        this.quizRepository = quizRepository;
    }
}