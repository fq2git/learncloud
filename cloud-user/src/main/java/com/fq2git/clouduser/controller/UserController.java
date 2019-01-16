package com.fq2git.clouduser.controller;

import com.fq2git.clouduser.model.User;
import com.fq2git.clouduser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getuser")
    public User getUser(){
        return  userService.getUser();
    }
}
