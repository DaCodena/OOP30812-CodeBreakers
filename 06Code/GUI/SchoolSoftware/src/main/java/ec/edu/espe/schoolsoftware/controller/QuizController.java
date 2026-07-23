/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.model.Course;
import ec.edu.espe.schoolsoftware.model.Quiz;
import ec.edu.espe.schoolsoftware.repository.ICrudOperations;

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