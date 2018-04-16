package be.ucll.project.test;

import be.ucll.project.db.*;
import be.ucll.project.domain.Activity;
import be.ucll.project.domain.ActivityService;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class ServiceTest {
    private String name = "Working for IP";
    private String description = "Make domain and smoke test";
    private String date = "25/06/2018";
    private LocalTime startTime = LocalTime.of(12,0);
    private LocalTime endTime = LocalTime.of(15,0);
    private String location = "At home";
    private Activity newActivity;
    private ActivityService service = new ActivityService("");

    @Test
    public void testValidActivity(){
        newActivity = new Activity(name, description, date, startTime , endTime, location);

        Assert.assertEquals(name, newActivity.getName());
        Assert.assertEquals(description, newActivity.getDescription());
        Assert.assertEquals(date, newActivity.getDate());
        Assert.assertEquals(startTime, newActivity.getStartTime());
        Assert.assertEquals(endTime, newActivity.getEndTime());
        Assert.assertEquals(location, newActivity.getLocation());
    }

    @Test
    public void testAddActivity(){
        service.addActivity(newActivity);
        List<Activity> test = service.getActivities();
        Assert.assertTrue(test.contains(newActivity));
    }

    @Test
    public void testGetActivity(){
        Assert.assertEquals(newActivity,service.getActivity(0));
    }

    @Test
    public void testUpdateActivity(){
        Activity newerActivity = new Activity("Not working for IP", "Not doing what I am supposed to do",date,startTime,endTime,location);
        service.updateActivity(0,newerActivity);
        Assert.assertNotEquals(newActivity,service.getActivity(0));
        Assert.assertEquals(newerActivity, service.getActivity(0));
    }

    @Test
    public void testDeleteActivity(){
        service.deleteActivity(0);
        Assert.assertTrue(service.getActivities().isEmpty());
    }

    @Test
    public void testAddMultipleActivities(){
        Activity a1 = new Activity("1", "test",date,startTime,endTime,location);
        Activity a2 = new Activity("2", "test",date,startTime,endTime,location);
        Activity a3 = new Activity("3", "test",date,startTime,endTime,location);
        Activity a3duplicate = new Activity("3", "test",date,startTime,endTime,location);
        service.addActivity(a1);
        service.addActivity(a2);
        service.addActivity(a3);
        service.addActivity(a3duplicate);

        Assert.assertEquals(3,service.getActivities().size());
    }
}
