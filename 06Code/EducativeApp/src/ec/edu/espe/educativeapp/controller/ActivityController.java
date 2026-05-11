package ec.edu.espe.educativeapp.controller;

import ec.edu.espe.educativeapp.model.Activity;
import java.util.ArrayList;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class ActivityController {

    private ArrayList<Activity> activities;

    public ActivityController() {
        activities = new ArrayList<>();
    }

    public void createActivity(int id, String title, double maxScore) {
        Activity activity = new Activity(id, title, maxScore);
        activities.add(activity);
    }

    public void showActivities() {
        for(Activity activity : activities) {
            System.out.println(activity.getTitle());
        }
    }

    public Activity findActivityById(int id) {
        for(Activity activity : activities) {
            if(activity.getId() == id) {
                return activity;
            }
        }

        return null;
    }
}