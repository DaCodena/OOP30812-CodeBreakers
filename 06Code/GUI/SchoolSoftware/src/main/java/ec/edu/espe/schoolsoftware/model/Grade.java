/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

import java.util.Objects;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Grade {
    private String id;
    private String studentId;
    private double score;
    private String feedback;

    public Grade() {
    }

    public Grade(String id, String studentId, double score, String feedback) {
        this.id = id;
        this.studentId = studentId;
        this.score = score;
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getScore() {
        return score;
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

    @Override
    public String toString() {
        return "Grade{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", score=" + score +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Double.compare(grade.score, score) == 0 &&
               Objects.equals(id, grade.id) &&
               Objects.equals(studentId, grade.studentId) &&
               Objects.equals(feedback, grade.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, score, feedback);
    }
}
