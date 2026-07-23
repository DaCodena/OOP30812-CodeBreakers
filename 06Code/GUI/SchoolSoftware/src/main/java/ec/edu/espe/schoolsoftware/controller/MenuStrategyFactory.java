/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.model.User;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class MenuStrategyFactory {
    public static MenuStrategy create(User user) {

        switch (user.getRole()) {

            case "ADMIN" -> {
                return new AdminMenuStrategy();
            }

            case "TEACHER" -> {
                return new TeacherMenuStrategy();
            }

            case "STUDENT" -> {
                return new StudentMenuStrategy();
            }

            default -> throw new IllegalArgumentException("Invalid role");

        }
    }
}
