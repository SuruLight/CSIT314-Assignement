package com.FRA.login_system.controller.FSACategoryController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.FSACategoryService.DeleteFSACategoryService;

@RestController
@RequestMapping("/api/management/fsa-category")
@CrossOrigin(origins = "*")
public class DeleteFSACategoryController {

    @Autowired
    private DeleteFSACategoryService deleteFSACategoryService;

    @DeleteMapping("/delete/{categoryID}")
    public String deleteFSACategory(@PathVariable int categoryID) {
        return deleteFSACategoryService.deleteFSACategory(categoryID);
    }
}