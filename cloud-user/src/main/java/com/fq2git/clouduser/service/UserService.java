package com.fq2git.clouduser.service;

import com.fq2git.clouduser.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(){
        User user = new User(1,"fangqiang","123456");
        return user;
    }


}
