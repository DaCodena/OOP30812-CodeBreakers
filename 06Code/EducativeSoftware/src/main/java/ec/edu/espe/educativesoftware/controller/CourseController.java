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

    private final CourseDAO courseDAO;

    public CourseController() {
        courseDAO = new CourseDAO();
    }

    public void saveCourse(Course course) {
        courseDAO.save(course);
    }

    public List<Course> getAllCourses() {
        return courseDAO.findAll();
    }
}