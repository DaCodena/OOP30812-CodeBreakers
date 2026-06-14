/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;


/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public interface CrudOperations<T> {
    
    void save(T object);
    
    void update(T object);
    
    void delete(String id);
    
    T findById(String id);
    
}
