package com.jxdedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"username","msg"}) 
public class UserController {
    
    @RequestMapping("/login")
    public String login(String loginName, String loginPassword, Model model){
        model.addAttribute("username", loginName == null? "null":loginName);
        model.addAttribute("password", loginPassword == null? "null":loginPassword);
        return "index.jsp";
    }
}
