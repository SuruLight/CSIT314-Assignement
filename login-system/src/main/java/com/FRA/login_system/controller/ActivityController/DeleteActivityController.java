package com.FRA.login_system.controller.ActivityController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.ActivityService.DeleteActivityService;

@RestController
@RequestMapping("/api/fr/activities")
@CrossOrigin(origins = "*")
public class DeleteActivityController {

    @Autowired
    private DeleteActivityService deleteActivityService;

    @DeleteMapping("/delete/{activityID}")
    public String deleteActivity(@PathVariable String activityID) {
        return deleteActivityService.deleteActivity(activityID);
    }
}