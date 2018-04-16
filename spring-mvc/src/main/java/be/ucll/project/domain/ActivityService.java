package be.ucll.project.domain;

import be.ucll.project.db.ActivityDb;
import be.ucll.project.db.ActivityDbFactory;
import be.ucll.project.db.ActivityDbInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ActivityService {
    private ActivityDb activities;

    @Autowired
    public ActivityService(String type) {
        this.activities = ActivityDbFactory.getActivityDb(type);
    }

    public void addActivity(Activity newActivity){
        activities.addActivity(newActivity);
    }

    public List<Activity> getActivities(){
        return activities.getActivities();
    }

    public void deleteActivity(int id){
        activities.deleteActivity(id);
    }

    public void updateActivity(int id, Activity activity){
        activities.updateActivity(id, activity);
    }

    public Activity getActivity(int id){
        return activities.getActivity(id);
    }
}
