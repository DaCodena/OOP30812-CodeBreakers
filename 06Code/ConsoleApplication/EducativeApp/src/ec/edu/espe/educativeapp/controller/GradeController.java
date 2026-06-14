/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativeapp.controller;

import ec.edu.espe.educativeapp.model.Activity;
import ec.edu.espe.educativeapp.model.Grade;
import ec.edu.espe.educativeapp.model.Student;
import java.util.ArrayList;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class GradeController {
      private ArrayList<Grade> grades;

    public GradeController() {
        grades = new ArrayList<>();
    }

    public void registerGrade(Student student, Activity activity, double score, String feedback) {
        Grade grade = new Grade(student, activity, score, feedback);
        grades.add(grade);
    }

    public void showGrades() {
        for(Grade grade : grades) {
            System.out.println(
                grade.getStudent().getName() +
                " - " +
                grade.getActivity().getTitle() +
                " - " +
                grade.getScore()
            );
        }
    }
}