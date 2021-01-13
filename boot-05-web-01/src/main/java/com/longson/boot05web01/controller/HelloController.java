package com.longson.boot05web01.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.reactive.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@RestController
public class HelloController {

    @RequestMapping("/555.jpg")
    public String bug(Model model){
        return "aaa";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)

    public String getUser(){

        return "GET-张三";

    }


    @RequestMapping(value = "/user",method = RequestMethod.POST)

    public String saveUser(){

        return "POST-张三";

    }



    @RequestMapping(value = "/user",method = RequestMethod.PUT)

    public String putUser(){

        return "PUT-张三";

    }


    @RequestMapping(value = "/user",method = RequestMethod.DELETE)

    public String deleteUser(){

        return "DELETE-张三";

    }


}
