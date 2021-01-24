package com.longson.boot05web01.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewContrller {

    @GetMapping("atguigu")
    public String atguiGU(Model model){
        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","你好回顾");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
















}
