/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private int day;
    private String month;
    private int year;

    public Student(String id, String firstName, String lastName,
            int day, String month, int year) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}