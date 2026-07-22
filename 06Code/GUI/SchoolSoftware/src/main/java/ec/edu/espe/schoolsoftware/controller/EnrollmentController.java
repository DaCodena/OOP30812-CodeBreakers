package ec.edu.espe.schoolsoftware.controller;


import ec.edu.espe.schoolsoftware.model.Enrollment;
import ec.edu.espe.schoolsoftware.repository.EnrollmentRepository;

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
        this.enrollmentRepository = new EnrollmentRepository();
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
