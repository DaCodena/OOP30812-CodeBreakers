package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Enrollment;
import ec.edu.espe.schoolsoftware.repository.EnrollmentRepository;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class EnrollmentController {

    private EnrollmentRepository enrollmentRepository;

    public EnrollmentController(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public EnrollmentController() {
    }

    public boolean enrollStudent(String enrollmentId, String courseId, String studentId) {

        Enrollment enrollment = new Enrollment(
                enrollmentId,
                courseId,
                studentId);

        enrollmentRepository.save(enrollment);

        return true;
    }

    public boolean removeStudentFromCourse(String enrollmentId) {

        enrollmentRepository.delete(enrollmentId);

        return true;
    }

    public int countStudentsPerCourse(String courseId) {

        int count = 0;

        for (Enrollment enrollment
                : enrollmentRepository.read()) {

            if (enrollment.getCourseId()
                    .equals(courseId)) {

                count++;

            }
        }

        return count;
    }

    public EnrollmentRepository getEnrollmentRepository() {
        return enrollmentRepository;
    }

    public void setEnrollmentRepository(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

}
