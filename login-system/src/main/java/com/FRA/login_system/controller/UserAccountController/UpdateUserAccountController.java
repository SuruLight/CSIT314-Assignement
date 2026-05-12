package com.FRA.login_system.controller.UserAccountController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.service.UserAccountService.UpdateUserAccountService;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
public class UpdateUserAccountController {

    @Autowired
    private UpdateUserAccountService updateUserAccountService;

    @PutMapping("/update")
    public UserAccount updateUserAccount(@RequestBody Map<String, String> request) {
        String username = request.get("accountName"); // Matches HTML 'accountName'
        String roleType = request.get("roleType");    // Matches HTML 'roleType' (e.g., "FR")
        String permissions = request.get("permissions");

        return updateUserAccountService.updateUserAccount(username, roleType, permissions);
    }
}