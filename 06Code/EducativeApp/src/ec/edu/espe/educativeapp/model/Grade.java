package ec.edu.espe.educativeapp.model;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Grade {
    
    private Student student;
    private Activity activity;
    private double score;
    private String feedback;

    public Grade(Student student, Activity activity, double score, String feedback) {
        this.student = student;
        this.activity = activity;
        this.score = score;
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Grade{" + "student=" + student + ", activity=" + activity + ", score=" + score + ", feedback=" + feedback + '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
}