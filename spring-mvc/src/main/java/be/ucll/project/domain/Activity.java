package be.ucll.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Activity {


    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;
    private String date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    public Activity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        if(date == null){
            throw new IllegalArgumentException("Date is null");
        }
        LocalDate help = LocalDate.parse(date, formatter);
        this.date = help.format(formatter);
    }

    public void setStartTime(LocalTime startTime) {
        if(startTime == null){
            throw new IllegalArgumentException("Start time is null");
        }
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        if(endTime == null){
            throw new IllegalArgumentException("End time is null");
        }
        this.endTime = endTime;
    }

    public void setLocation(String location) {
        if(location == null){
            throw new IllegalArgumentException("Location is null");
        }
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return this.date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }


    public Activity(String name, String description, String date, LocalTime startTime, LocalTime endTime, String location) {
        setDate(date);
        setDescription(description);
        setEndTime(endTime);
        setLocation(location);
        setName(name);
        setStartTime(startTime);
    }

    @Override
    public boolean equals(Object o){
        Activity a = (Activity) o;
        if(!(a.getDescription().equals(this.description))) return false;
        if(!(a.getName().equals(this.name))) return false;
        if(!(a.getDate().equals(this.date))) return false;
        if(!(a.getStartTime().equals(this.startTime))) return false;
        if(!(a.getEndTime().equals(this.endTime))) return false;
        if(!(a.getLocation().equals(this.location))) return false;
        return true;
    }
}
