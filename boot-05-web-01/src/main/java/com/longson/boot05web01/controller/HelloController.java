package com.longson.boot05web01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/555.jpg")
    public String bug(){
        return "aaa";
    }

}
