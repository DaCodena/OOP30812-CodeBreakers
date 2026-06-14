/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware.model;

import java.time.LocalDate;
/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

public class Grade {

    private String gradeId;

    private float score;

    private String feedback;

    private LocalDate date;

    public Grade() {
    }

    public Grade(String gradeId,
            float score,
            String feedback,
            LocalDate date) {

        this.gradeId = gradeId;
        this.score = score;
        this.feedback = feedback;
        this.date = date;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}