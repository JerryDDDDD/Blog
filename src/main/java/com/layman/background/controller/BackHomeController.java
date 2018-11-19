package com.layman.background.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backgroundhome")
public class BackHomeController {

    @RequestMapping("/writeArticle")
    public String writeArticle(){
        return "/background/writearticle";
    }
}
