/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativeapp.model;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Statistic {
    private String statisticId;
    private double averageGrade;
    private double highestGrade;
    private double lowestGrade;
    private String difficultQuestions;
    private double participantRate;
    private Course courseInformation;

    /**
     * @return the statisticId
     */
    public String getStatisticId() {
        return statisticId;
    }

    /**
     * @param statisticId the statisticId to set
     */
    public void setStatisticId(String statisticId) {
        this.statisticId = statisticId;
    }

    /**
     * @return the averageGrade
     */
    public double getAverageGrade() {
        return averageGrade;
    }

    /**
     * @param averageGrade the averageGrade to set
     */
    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    /**
     * @return the highestGrade
     */
    public double getHighestGrade() {
        return highestGrade;
    }

    /**
     * @param highestGrade the highestGrade to set
     */
    public void setHighestGrade(double highestGrade) {
        this.highestGrade = highestGrade;
    }

    /**
     * @return the lowestGrade
     */
    public double getLowestGrade() {
        return lowestGrade;
    }

    /**
     * @param lowestGrade the lowestGrade to set
     */
    public void setLowestGrade(double lowestGrade) {
        this.lowestGrade = lowestGrade;
    }

    /**
     * @return the difficultQuestions
     */
    public String getDifficultQuestions() {
        return difficultQuestions;
    }

    /**
     * @param difficultQuestions the difficultQuestions to set
     */
    public void setDifficultQuestions(String difficultQuestions) {
        this.difficultQuestions = difficultQuestions;
    }

    /**
     * @return the participantRate
     */
    public double getParticipantRate() {
        return participantRate;
    }

    /**
     * @param participantRate the participantRate to set
     */
    public void setParticipantRate(double participantRate) {
        this.participantRate = participantRate;
    }

    /**
     * @return the courseInformation
     */
    public Course getCourseInformation() {
        return courseInformation;
    }

    /**
     * @param courseInformation the courseInformation to set
     */
    public void setCourseInformation(Course courseInformation) {
        this.courseInformation = courseInformation;
    }
    
    
}
