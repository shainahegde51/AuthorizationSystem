package com.example.AuthorizationSystem.controller;

import com.example.AuthorizationSystem.entity.User;
import com.example.AuthorizationSystem.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    //to add new user
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }


    //This method has to be run when ever we build the application.
    // To do that we use this annotation called "Post Construct"

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRoleAndUser();
    }
}
