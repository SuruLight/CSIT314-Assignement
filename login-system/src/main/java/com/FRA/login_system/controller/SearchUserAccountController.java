package com.FRA.login_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.service.SearchUserAccountService;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
public class SearchUserAccountController {

    @Autowired
    private SearchUserAccountService searchUserService;

    @GetMapping("/search")
    public List<User> validateSearch(@RequestParam String keyword) {
        return fetchUserDetails(keyword);
    }

    public List<User> fetchUserDetails(String keyword) {
        return searchUserService.searchUser(keyword);
    }
}