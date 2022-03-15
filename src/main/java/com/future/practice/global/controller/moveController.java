package com.future.practice.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class moveController {

    @GetMapping("/boardAdd")
    public String boardMove(){
        return "/boardAdd";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "main";
    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }
    @GetMapping("/main/search")
    public String searchMain(){
        return "main";
    }
    @GetMapping("/mainDetail")
    public String mainDetail(){
        return "mainDetail";
    }
    @GetMapping("/myPage")
    public String myPage(){
        return "myPage";
    }
    @GetMapping("/sign")
    public String sign(){
        return "/sign";
    }
    @GetMapping("/boardUpdate")
    public String boardUpdate() {return "/boardUpdate";}
}
