package com.layman.background.controller;

import com.layman.background.service.UserService;
import com.layman.util.CaptchaUtil;
import com.layman.util.CookieUtils;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;

    // @RequestParam("captcha") String captcha
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,@Nullable @RequestParam("inputusername") String username ,
                       @Nullable @RequestParam("inputpassword") String password
                       ) throws IOException {
        //System.out.println(request.getSession().getAttribute("randomString"));
//        if (!request.getSession().getAttribute("randomString").equals(captcha)) {
//            System.out.println("验证码错误");
//        }

        Cookie[] cookies = request.getCookies();
        if (CookieUtils.findCookie(cookies, "last")!=null){
            return "background/home";
        }

        if (userService.checkUser(username,password)){

            Cookie cookie = CookieUtils.findCookie(cookies, "last");
            //是第一次登录，没有cookie
            if(cookie == null){

                Cookie c = new Cookie("last", System.currentTimeMillis()+"");
                c.setMaxAge(60*60); //一个小时
                response.addCookie(c);
                response.getWriter().write("欢迎您, "+username);
                return "background/home";
            }else{
                //1. 去以前的cookie第二次登录，有cookie
                long lastVisitTime = Long.parseLong(cookie.getValue());

                //2. 输出到界面，
                response.getWriter().write("欢迎您, "+username +",上次来访时间是："+new Date(lastVisitTime));


                //3. 重置登录的时间
                cookie.setValue(System.currentTimeMillis()+"");
                response.addCookie(cookie);
            }
        }else{
            response.getWriter().write("登陆失败 ");
        }
        return "/404";
    }

    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CaptchaUtil.outputCaptcha(request, response);
    }
}
