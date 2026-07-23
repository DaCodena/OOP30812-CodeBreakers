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
public class StudentTest {

    public StudentTest() {
    }

    @Test
    public void testStudentCreation() {

        Student student = new Student(
                "L001",
                "Pedro",
                "Sanchez",
                10,
                "july",
                2004
        );

        assertEquals("Pedro", student.getNames());
        assertEquals("Sanchez", student.getSurnames());
        assertEquals(10, student.getDay());
        assertEquals("july", student.getMonth());
        assertEquals(2004, student.getYear());

    }

}
