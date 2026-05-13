package com.FRA.login_system.controller.FSACategoryController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.FSACategoryService.UpdateFSACategoryService;

@RestController
@RequestMapping("/api/management/fsa-category")
@CrossOrigin(origins = "*")
public class UpdateFSACategoryController {

    @Autowired
    private UpdateFSACategoryService updateFSACategoryService;

    @PutMapping("/update")
    public String updateFSACategory(@RequestBody Map<String, String> request) {

        int categoryID = Integer.parseInt(request.get("categoryID"));
        String categoryName = request.get("categoryName");
        String categoryDescription = request.get("categoryDescription");

        return updateFSACategoryService.updateFSACategory(categoryID, categoryName, categoryDescription);
    }
}