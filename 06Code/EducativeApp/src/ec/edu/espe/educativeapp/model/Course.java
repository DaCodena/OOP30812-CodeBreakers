package ec.edu.espe.educativeapp.model;

import java.util.ArrayList;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Course {
    private int id;
    private String name;
    private ArrayList<Student> students;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", students=" + students + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    
}