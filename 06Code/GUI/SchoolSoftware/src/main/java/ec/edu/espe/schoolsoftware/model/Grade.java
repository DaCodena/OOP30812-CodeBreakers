/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Grade {

    private String id;
    private String studentId;
    private double score;
    private String feedback;

    public Grade(String id, String studentId, double score, String feedback) {
        this.id = id;
        this.studentId = studentId;
        this.score = score;
        this.feedback = feedback;
    }



    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getScore() {
        return score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}