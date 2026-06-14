/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware;

import ec.edu.espe.educativesoftware.controller.CourseController;
import ec.edu.espe.educativesoftware.dao.CourseDAO;
import ec.edu.espe.educativesoftware.model.Course;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class TestCourseDAO {

    public static void main(String[] args) {

        CourseController controller
                = new CourseController();

        controller.getAllCourses()
                .forEach(System.out::println);
    }
}
