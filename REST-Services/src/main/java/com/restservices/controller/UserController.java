package com.restservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public String getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/create")
    public String createUser() {
        return userService.createUser();
    }

    @GetMapping("/update")
    public String updateUser() {
        userService.updateUser();
        return "User updated successfully!";
    }

    @GetMapping("/delete")
    public String deleteUser() {
        userService.deleteUser();
        return "User deleted successfully!";
    }
}
