package ec.edu.espe.educativeapp.controller;

import ec.edu.espe.educativeapp.model.Course;
import ec.edu.espe.educativeapp.model.Student;
import java.util.ArrayList;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class CourseController {

    private ArrayList<Course> courses;

    public CourseController() {
        courses = new ArrayList<>();
    }

    public void createCourse(int id, String name) {
        Course course = new Course(id, name);
        courses.add(course);
    }

    public void showCourses() {
        for(Course course : courses) {
            System.out.println(course);
        }
    }

    public Course findCourseById(int id) {
        for(Course course : courses) {
            if(course.getId() == id) {
                return course;
            }
        }

        return null;
    }

    public void assignStudent(Course course, Student student) {
        course.addStudent(student);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}