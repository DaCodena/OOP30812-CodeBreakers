package ec.edu.espe.educativeapp.controller;

import java.util.ArrayList;
import ec.edu.espe.educativeapp.model.Student;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class StudentController {

    private ArrayList<Student> students;

    public StudentController() {
        students = new ArrayList<>();
    }

    public void createStudent(int id, String name, double average) {
        Student student = new Student(id, name, average);
        students.add(student);
    }

    public void showStudents() {
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student findStudentById(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}