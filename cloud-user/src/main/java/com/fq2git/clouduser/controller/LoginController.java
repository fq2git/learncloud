package com.fq2git.clouduser.controller;

import com.fq2git.clouduser.constant.CookieConstant;
import com.fq2git.clouduser.constant.RedisConstant;
import com.fq2git.clouduser.utils.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/login")
    public String userLogin(@RequestParam("password") String password,
                            HttpServletResponse response,
                            HttpServletRequest request){
        //判断是否已经登录
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie != null && !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
            return "登录成功";
        }
        //判断登录名密码是否一致
        if(!("123456").equals(password)){
            return "登录失败";
        }
        //redis设置key=UUID,Value password
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),
                password,
                expire,TimeUnit.SECONDS);

        //cookie里设置password = 123456
        CookieUtil.set(response,CookieConstant.TOKEN,token,CookieConstant.expire);
        return "登录成功";
    }
}
