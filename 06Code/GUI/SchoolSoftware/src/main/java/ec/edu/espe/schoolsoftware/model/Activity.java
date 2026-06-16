/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Activity {

    private String id;
    private String courseId;
    private String title;

    public Activity(String id, String courseId, String title) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }
}