/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.view.FrmMenu;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class StudentMenuStrategy implements MenuStrategy {

    @Override
    public void configureMenu(FrmMenu menu) {
        menu.getMenuManage().setVisible(false);
        menu.getMenuActivities().setVisible(false);
        menu.getMenuAlerts().setVisible(false);
        menu.getMenuReports().setVisible(false);
    }
    
}
