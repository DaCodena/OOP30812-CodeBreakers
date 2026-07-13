/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import java.util.ArrayList;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public interface IFindByName<T> {
        ArrayList<T> findByName(String name);
}
