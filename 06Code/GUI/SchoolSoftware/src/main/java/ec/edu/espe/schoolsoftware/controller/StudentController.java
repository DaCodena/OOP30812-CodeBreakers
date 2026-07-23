package ec.edu.espe.schoolsoftware.controller;

import ec.edu.espe.schoolsoftware.repository.StudentRepository;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentController() {
        this.studentRepository = new StudentRepository();
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

}
