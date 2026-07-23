/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public abstract class AssessmentTool {

    protected String id;
    protected String courseId;
    protected String title;

    public AssessmentTool(String id, String courseId, String title) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
