/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Quiz {

    private String id;
    private String courseId;
    private String title;

    public Quiz(String id, String courseId, String title) {
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