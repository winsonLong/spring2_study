package com.atguigu.boot05webadmin.controller;

import com.atguigu.boot05webadmin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /*
    * 来登录页
    * */
    @GetMapping(value={"/","/login"})
    public String loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(!StringUtils.isEmpty(user.getUsername())&&"123456".equals(user.getPassword())) {
            //把登陆上成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登陆成功后重定向到main.html,重定向防止标单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","请重新登陆");
            return "login";
        }
    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        Object loginUser =session.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }else{
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
    }

}
