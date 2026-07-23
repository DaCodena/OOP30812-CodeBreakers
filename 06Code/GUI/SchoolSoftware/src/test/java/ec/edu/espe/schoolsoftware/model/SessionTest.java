/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class SessionTest {

    @Test
    public void testSetCurrentUser() {

        User user = new User("admin", "1234", "Administrator");

        Session.setCurrentUser(user);

        assertEquals(user, Session.getCurrentUser());
    }

    @Test
    public void testLogout() {

        User user = new User("teacher", "abcd", "Teacher");

        Session.setCurrentUser(user);

        Session.logout();

        assertNull(Session.getCurrentUser());
    }

    @Test
    public void testChangeCurrentUser() {

        User user1 = new User("admin", "1234", "Administrator");
        User user2 = new User("student", "5678", "Student");

        Session.setCurrentUser(user1);
        assertEquals(user1, Session.getCurrentUser());

        Session.setCurrentUser(user2);
        assertEquals(user2, Session.getCurrentUser());
    }
}
