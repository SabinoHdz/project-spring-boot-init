package com.springboot.webapp.springboot_webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.webapp.springboot_webapp.models.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/details")
    public String deatils(Model model){
        User user = new User("Sabino", "Hernández");
        model.addAttribute("title"," Hola mundo desde Spring");
      model.addAttribute("user",user);

        
        return  "details";
    }
    
}
