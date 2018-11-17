package com.layman.background.controller;

import com.layman.background.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("inputusername") String username , @RequestParam("inputpassword") String password){
        System.out.println(username);
        if (userService.checkUser(username,password)){
            return "common/home";
        }else {
            return "/404";
        }

    }
}
