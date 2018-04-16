package be.ucll.project.web.controller;

import be.ucll.project.domain.Activity;
import be.ucll.project.domain.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.ws.rs.Path;


@Controller
@ComponentScan
@RequestMapping(value = "/activity")
public class ActivityController {

    private ActivityService service;

    public ActivityController(@Autowired ActivityService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView  getActivities(){
        return new ModelAndView("overview", "activities", service.getActivities());
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView getNewForm(){
        ModelAndView mv = new ModelAndView("activityForm", "activity", new Activity());
        mv.addObject("post_url", "/project/activity/save.htm");
        return mv;
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Activity activity, BindingResult result){
        if(result.hasErrors()){
            return "activityForm";
        }
        service.addActivity(activity);
        return "redirect:/activity.htm";
    }

    @RequestMapping(value="/edit-{key}", method = RequestMethod.POST)
    public String edit(Activity activity, BindingResult result, @PathVariable int key){
        if(result.hasErrors()){
            return "activityForm";
        }
        service.updateActivity(key, activity);
        return "redirect:/activity.htm";
    }

    @RequestMapping(value = "/{key}-editForm", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable int key){
        ModelAndView mv = new ModelAndView("activityForm", "activity", service.getActivity(key));
        mv.addObject("post_url", "/project/activity/edit-" + key + ".htm");
        mv.addObject("key", key);
        return mv;
    }

    @RequestMapping(value = "/{key}-delete", method = RequestMethod.GET)
    public String delete(@PathVariable int key){
        service.deleteActivity(key);
        return "redirect:/activity.htm";
    }
}
