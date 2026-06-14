/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware.controller;

import ec.edu.espe.educativesoftware.dao.CourseDAO;
import ec.edu.espe.educativesoftware.model.Course;
import java.util.List;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class CourseController {

    private final CourseDAO dao;

    public CourseController() {
        dao = new CourseDAO();
    }

    public void saveCourse(Course course) {
        dao.save(course);
    }

    public List<Course> getAllCourses() {
        return dao.findAll();
    }

    public Course findById(String courseId) {
        return dao.findById(courseId);
    }

    public void updateCourse(Course course) {
        dao.update(course);
    }

    public void deleteCourse(String courseId) {
        dao.delete(courseId);
    }
    
    public List<Course> searchCourses(
        String name,
        String subject,
        String teacher){

    return dao.search(
            name,
            subject,
            teacher);
}
}