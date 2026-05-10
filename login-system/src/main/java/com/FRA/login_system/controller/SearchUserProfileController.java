package com.FRA.login_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.service.SearchUserProfileService;

@RestController
@RequestMapping("/api/admin/user-profiles")
@CrossOrigin(origins = "*")
public class SearchUserProfileController {

    @Autowired
    private SearchUserProfileService searchUserProfileService;

    @GetMapping("/search")
    public List<User> searchUser(@RequestParam String criteria) {
        return searchUserProfileService.searchUser(criteria);
    }
}