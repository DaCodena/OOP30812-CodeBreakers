package ec.edu.espe.educativeapp.model;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Activity {
    
    private int id;
    private String title;
    private double maxScore;

    public Activity(int id, String title, double maxScore) {
        this.id = id;
        this.title = title;
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        return "Activity{" + "id=" + id + ", title=" + title + ", maxScore=" + maxScore + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }
    
}