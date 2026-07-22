package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Grade;
import ec.edu.espe.schoolsoftware.repository.GradeRepository;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class GradeController {

    private GradeRepository gradeRepository;

    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public GradeController() {
    }

    public boolean assignGrade(Grade grade) {

        gradeRepository.save(grade);

        return true;
    }

    public double calculateAverageGrade() {

        ArrayList<Grade> grades = gradeRepository.read();

        double total = 0;

        for (Grade grade : grades) {
            total += grade.getScore();
        }

        return grades.isEmpty() ? 0 : total / grades.size();
    }

    public boolean detectLowPerformance(String studentId) {

        ArrayList<Grade> grades = gradeRepository.read();

        double total = 0;
        int count = 0;

        for (Grade grade : grades) {

            if (grade.getStudentId()
                    .equals(studentId)) {

                total += grade.getScore();
                count++;

            }
        }

        if (count == 0) {
            return false;
        }

        return total / count < 70;
    }

    public void generateFeedback(String gradeId) {
        Grade grade = gradeRepository.findById(gradeId);

        String feedback;

        if (grade.getScore() >= 90) {

            feedback = "Excellent performance";

        } else if (grade.getScore() >= 70) {

            feedback = "Good performance";

        } else {

            feedback = "Needs improvement";

        }

        grade.setFeedback(feedback);

        gradeRepository.update(grade);
    }

    public GradeRepository getGradeRepository() {
        return gradeRepository;
    }

    public void setGradeRepository(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

}
