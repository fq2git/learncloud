package com.fq2git.clouduser.controller;

import com.fq2git.clouduser.model.User;
import com.fq2git.clouduser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getuser")
    public User getUser(HttpServletResponse response){
        return  userService.getUser();
    }
}
