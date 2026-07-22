/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.model.Course;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public interface ICreate<T> {
    T create(Course course);
}