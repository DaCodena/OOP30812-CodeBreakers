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
public class Activity {

    private String activityId;
    private String title;
    private String description;

    private ActivityType type;

    private LocalDate deadline;

    private float maxScore;

    public Activity() {
    }

    public Activity(String activityId,
            String title,
            String description,
            ActivityType type,
            LocalDate deadline,
            float maxScore) {

        this.activityId = activityId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.deadline = deadline;
        this.maxScore = maxScore;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public float getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(float maxScore) {
        this.maxScore = maxScore;
    }
}