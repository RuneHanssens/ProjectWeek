package be.ucll.project.db;

import be.ucll.project.domain.Activity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class ActivityDbInMemory implements ActivityDb{
    private HashMap<Long,Activity> activities;

    public ActivityDbInMemory() {
        this.activities = new HashMap<>();
        //generateContent();
    }

    @Override
    public List<Activity> getActivities() {
        return null;
    }

    @Override
    public void addActivity(Activity newActivity) {
        if(!(activities.containsValue(newActivity))) {
            this.activities.put(generateNewId(), newActivity);
        }
    }

    @Override
    public void deleteActivity(long id) {
        this.activities.remove(id);
    }

    @Override
    public void updateActivity(long id, Activity activity) {
        activities.remove(id);
        activities.put(id, activity);
    }

    @Override
    public Activity getActivity(long id) {
        return activities.get(id);
    }

    @Override
    public String toString(){
        String result = "";
        for(Map.Entry<Long, Activity> entry : activities.entrySet()){
            result += "id: " + entry.getKey() + "| " + entry.getValue().getName() + ", "  + entry.getValue().getDescription() + "\n";
        }
        return result;
    }

    private long generateNewId(){
        long result = 0;
        if (activities.isEmpty()){
            System.out.println("id is 0");
            return 0;
        }
        for (Long id: activities.keySet()){
            if (result <= id){
                result = id;
            }
        }
        result ++;
        System.out.println("id is " + result);
        return result;
    }

    private void generateContent(){
        String date = "25/07/2019";
        LocalTime start = LocalTime.of(18,0);
        LocalTime end = LocalTime.of(21,0);
        Activity newActivity = new Activity("Study for IP", "Make domain & JSP for IP", date, start, end, "At home");
        this.addActivity(newActivity);

        date = "26/09/2018";
        start = LocalTime.of(23,0);
        end = LocalTime.of(3,0);
        Activity activity2 = new Activity("Drink a pintjen", "Drinking a cold stella with the boys", date, start, end, "At Recup");
        this.addActivity(activity2);

        System.out.println(this.toString());
    }
}
