package com.layman.background.controller;

import com.layman.background.service.UserService;
import com.layman.util.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;

    // @RequestParam("captcha") String captcha
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam("inputusername") String username ,
                        @RequestParam("inputpassword") String password
                       ){
        //System.out.println(request.getSession().getAttribute("randomString"));
//        if (!request.getSession().getAttribute("randomString").equals(captcha)) {
//            System.out.println("验证码错误");
//        }
        if ( userService.checkUser(username,password)){
            return "background/home";
        }else {
            return "/404";
        }
    }

    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CaptchaUtil.outputCaptcha(request, response);
    }
}
