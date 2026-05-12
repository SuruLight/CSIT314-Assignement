package com.FRA.login_system.controller.UserAccountController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.service.UserAccountService.SearchUserAccountService;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
public class SearchUserAccountController {

    @Autowired
    private SearchUserAccountService searchUserService;

    @GetMapping("/search")
    public List<UserAccount> validateSearch(@RequestParam String keyword) {
        return fetchUserDetails(keyword);
    }

    public List<UserAccount> fetchUserDetails(String keyword) {
        return searchUserService.searchUser(keyword);
    }
}