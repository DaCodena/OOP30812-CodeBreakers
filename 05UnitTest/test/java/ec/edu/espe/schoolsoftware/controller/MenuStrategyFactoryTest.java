/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.controller.AdminMenuStrategy;
import ec.edu.espe.schoolsoftware.controller.MenuStrategy;
import ec.edu.espe.schoolsoftware.controller.MenuStrategyFactory;
import ec.edu.espe.schoolsoftware.controller.StudentMenuStrategy;
import ec.edu.espe.schoolsoftware.controller.TeacherMenuStrategy;
import ec.edu.espe.schoolsoftware.model.User;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class MenuStrategyFactoryTest {

    @Test
    public void testCreateAdminStrategy() {

        User admin = new User("admin", "1234", "ADMIN");

        MenuStrategy strategy = MenuStrategyFactory.create(admin);

        assertTrue(strategy instanceof AdminMenuStrategy);
    }

    @Test
    public void testCreateTeacherStrategy() {

        User teacher = new User("teacher", "1234", "TEACHER");

        MenuStrategy strategy = MenuStrategyFactory.create(teacher);

        assertTrue(strategy instanceof TeacherMenuStrategy);
    }

    @Test
    public void testCreateStudentStrategy() {

        User student = new User("student", "1234", "STUDENT");

        MenuStrategy strategy = MenuStrategyFactory.create(student);

        assertTrue(strategy instanceof StudentMenuStrategy);
    }

    @Test
    public void testInvalidRole() {

        User user = new User("user", "1234", "GUEST");

        assertThrows(
                IllegalArgumentException.class,
                () -> MenuStrategyFactory.create(user)
        );
    }
}