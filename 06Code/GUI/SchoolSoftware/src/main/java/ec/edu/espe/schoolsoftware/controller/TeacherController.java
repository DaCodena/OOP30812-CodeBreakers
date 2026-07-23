/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.model.Grade;
import ec.edu.espe.schoolsoftware.repository.GradeRepository;
import ec.edu.espe.schoolsoftware.repository.TeacherRepository;

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
        this.teacherRepository = new TeacherRepository();
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
