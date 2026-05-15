package com.FRA.login_system.controller.FRAController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.FRAService.ViewFRAService;

@RestController
@RequestMapping("/api/fr/fra")
@CrossOrigin(origins = "*")
public class ViewFRAController {

    @Autowired
    private ViewFRAService viewFRAService;

    @GetMapping("/details/{fraId}")
    public String getFRAInfo(@PathVariable int fraId) {
        return viewFRAService.getFRAInfo(fraId);
    }
}