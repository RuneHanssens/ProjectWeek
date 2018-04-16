package be.ucll.project.web.controller;

import be.ucll.project.domain.Activity;
import be.ucll.project.domain.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/rest/activities")
public class ActivityRESTController {
    private ActivityService service;

    public ActivityRESTController(@Autowired ActivityService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Activity> getActivities(){
        System.out.println(service.getActivities());
        return service.getActivities();
    }
}

