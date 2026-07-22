/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

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
