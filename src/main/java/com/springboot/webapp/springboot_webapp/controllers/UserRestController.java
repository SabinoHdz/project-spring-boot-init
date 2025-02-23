package com.springboot.webapp.springboot_webapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springboot_webapp.models.User;
import com.springboot.webapp.springboot_webapp.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    //@RequestMapping(path ="/details", method = RequestMethod.GET)
    @GetMapping("/rest")
    public UserDto deatils(){
        UserDto userDto = new UserDto();
        User user = new User("Sabino", "Hernández");
        userDto.setTitle("Hola mundo desde Spring");
        userDto.setUser(user);
      
        return userDto;
        
    }
    @GetMapping("/list")
    public List<User> listUser(){
        User user = new User("Sabino", "Hernández");
        User user2 = new User("Aldo", "Lara");
        User user3 = new User("Luis", "Hernández");
        // List <User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        //List <User> users= Arrays.asList( user,user2,user3);
        List <User> users=List.of(user,user2,user3);

        return  users;
    }

    //resplado
    // public Map<String, Object> deatils() {
    //     Map<String, Object> body = new HashMap<>();
    //     User user = new User("Sabino", "Hernández");
    //     body.put("title", "Hola mundo desde Spring");
    //     body.put("user", user);
    //     return body;
    // }
    
}
