package com.FRA.login_system.controller.FRAController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.FRA;
import com.FRA.login_system.service.FRAService.ViewFRAListService;

@RestController
@RequestMapping("/api/fr/fra")
@CrossOrigin(origins = "*")
public class ViewFRAListController {

    @Autowired
    private ViewFRAListService viewFRAListService;

    @GetMapping("/all")
    public List<FRA> getFRAList() {
        return viewFRAListService.getFRAList();
    }
}