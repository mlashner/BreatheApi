package com.breathe.breatheApi.controllers;

import com.breathe.breatheApi.core.Admin;
import com.breathe.breatheApi.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.findAll();
    }

    @GetMapping("/{userId}")
    public Admin checkUserIsAdmin(@PathVariable("userId") Long userId) {
        return adminService.checkUserIsAdmin(userId);
    }

    @PostMapping
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable(value = "id") Long id) {
        adminService.deleteAdmin(id);
    }
}
