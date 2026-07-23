/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;


import ec.edu.espe.schoolsoftware.model.Activity;
import ec.edu.espe.schoolsoftware.model.Course;
import ec.edu.espe.schoolsoftware.repository.ActivityRepository;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class ActivityController implements ICreate<Activity> {

    private ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public ActivityController() {
        this.activityRepository = new ActivityRepository();
    }

    @Override
    public Activity create(Course course) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }

    public void setActivityRepository(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
}
