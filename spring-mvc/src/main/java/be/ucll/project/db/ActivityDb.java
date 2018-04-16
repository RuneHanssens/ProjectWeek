package be.ucll.project.db;

import be.ucll.project.domain.Activity;
import java.util.List;


public interface ActivityDb {
    List<Activity> getActivities();
    void addActivity(Activity newActivity);
    void deleteActivity(long id);
    void updateActivity(long id, Activity activity);
    Activity getActivity(long id);
    String toString();
}
