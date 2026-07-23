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


public class TeacherTest {

    @Test
    public void testTeacherCreation() {

        Teacher teacher = new Teacher(
                "T001",
                "Carlos",
                "Perez",
                "Biologist"
        );

        assertEquals("Carlos", teacher.getNames());
        assertEquals("Perez", teacher.getSurnames());
        assertEquals("Biologist", teacher.getProfession());

    }

}