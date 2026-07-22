/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Grade;
import ec.edu.espe.schoolsoftware.model.Teacher;
import ec.edu.espe.schoolsoftware.repository.GradeRepository;
import ec.edu.espe.schoolsoftware.repository.TeacherRepository;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.bson.Document;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class TeacherController {

    private TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherController() {
    }

    public boolean assignGrade(Grade grade) {
        GradeRepository gradeRepository = new GradeRepository(); 
        gradeRepository.save(grade);

        return true;
    }

    public TeacherRepository getTeacherRepository() {
        return teacherRepository;
    }

    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

}
