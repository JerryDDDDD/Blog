package com.layman.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/gethome",method = RequestMethod.GET)
    public String getHome(){
        return "/common/home";
    }

    @RequestMapping(value = "/getprofile",method = RequestMethod.GET)
    public String getProfile(){
        return "/common/profile";
    }

    @RequestMapping(value = "/getmessage",method = RequestMethod.GET)
    public String getMessage(){
        return "/common/message";
    }

    @RequestMapping(value = "/getsetting",method = RequestMethod.GET)
    public String getSetting(){
        return "/common/setting";
    }

    @RequestMapping(value = "/getabout",method = RequestMethod.GET)
    public String getAbout(){
        return "/common/about";
    }
}
