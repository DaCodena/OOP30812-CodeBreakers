/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import java.util.ArrayList;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public interface ICrudOperations<T> {

    void save(T object);

    ArrayList<T> read();

    void update(T object);

    void delete(String id);

    T findById(String id);
}
