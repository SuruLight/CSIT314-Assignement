package com.FRA.login_system.controller.FSACategoryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.FSACategory;
import com.FRA.login_system.service.FSACategoryService.ViewFSACategoryService;

@RestController
@RequestMapping("/api/management/fsa-category")
@CrossOrigin(origins = "*")
public class ViewFSACategoryController {

    @Autowired
    private ViewFSACategoryService viewFSACatService;

    @GetMapping("/view")
    public List<FSACategory> getFSACategories() {
        return viewFSACatService.getFSACategories();
    }
}