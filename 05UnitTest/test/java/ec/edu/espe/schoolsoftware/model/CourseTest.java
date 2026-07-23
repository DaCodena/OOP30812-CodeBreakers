/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class CourseTest {

    @Test
    public void testCourseCreation() {

        Course course = new Course(
                "POO",
                "Object Oriented Programming",
                "Jhon"
        );

        assertEquals("POO", course.getId());
        assertEquals("Object Oriented Programming", course.getName());

    }

}