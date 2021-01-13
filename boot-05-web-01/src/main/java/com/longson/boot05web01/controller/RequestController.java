package com.longson.boot05web01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotopage(HttpServletRequest request){
        request.setAttribute("msg","称公司了。。");
        request.setAttribute("code",200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request) {
        Object msg1=request.getAttribute("msg");
        Map<String,Object> map=new HashMap<>();
        map.put("reMethod_msg",msg1);
        map.put("annotation_msg",msg);
        return map;

    }
}
