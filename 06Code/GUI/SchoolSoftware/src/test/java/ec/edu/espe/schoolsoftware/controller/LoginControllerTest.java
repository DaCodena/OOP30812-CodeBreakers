/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.model.Session;
import ec.edu.espe.schoolsoftware.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class LoginControllerTest {

    public LoginControllerTest() {
    }

    @Test
    public void testLogout() {

        User user = new User("admin", "1234", "Administrator");

        Session.setCurrentUser(user);

        assertNotNull(Session.getCurrentUser());

        LoginController controller = new LoginController();

        controller.logout();

        assertNull(Session.getCurrentUser());

    }


}
