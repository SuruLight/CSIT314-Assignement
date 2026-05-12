package com.FRA.login_system.controller.FSACategoryController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.FSACategoryService.CreateFSACatService;

@RestController
@RequestMapping("/api/management/fsa-category")
@CrossOrigin(origins = "*")
public class CreateFSACatController {

    @Autowired
    private CreateFSACatService createFSACatService;

    @PostMapping("/create")
    public String createFSACat(@RequestBody Map<String, String> request) {
        String catName = request.get("catName");
        String catDesc = request.get("catDesc");

        return createFSACatService.createFSACat(catName, catDesc);
    }
}