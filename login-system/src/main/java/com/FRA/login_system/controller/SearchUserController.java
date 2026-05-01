package com.FRA.login_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.service.SearchUserService;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
public class SearchUserController {

    @Autowired
    private SearchUserService searchUserService;

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String keyword) {
        return searchUserService.searchUser(keyword);
    }
}