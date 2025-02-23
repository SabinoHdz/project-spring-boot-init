package com.springboot.webapp.springboot_webapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springboot_webapp.models.User;
import com.springboot.webapp.springboot_webapp.models.dto.ParamDto;

@RestController
@RequestMapping("/api/variables")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;
    @Value("${config.code}")
    private  Integer code;

    @Value("${values.list}")
    private String[]  listOfValues;

    //lenguaje de expresion de spring
    @Value("#{'${values.list}'.toUpperCase().split(',')}")
    private List   <String> valueList;

    @Value("#{'${values.list}'.toUpperCase()}")
    private String valueString;
    // @Value("#{${values.map}}")
    // private Map<String,Object> valuesMap;

    @Autowired
    private Environment environment;


    @GetMapping(value = "/path/{message}")
    public ParamDto path(@PathVariable String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        paramDto.setCode(200);
        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mix(@PathVariable String product, @PathVariable Integer id){
        Map<String,Object> map =new HashMap<>();
        map.put("product", product);
        map.put("id", id);
        return map;
    }

    @PostMapping(value = "/create")
    public User create(@RequestBody User user){
            user.setName(user.getName().trim().toUpperCase());
        return user;
    }

    @GetMapping("/config")
    public Map<String,Object> configuration(){
        Map<String,Object> json= new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("code", code);
        json.put("list", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);

        json.put("message 2", environment.getProperty("config.message"));
        json.put("code 2", environment.getProperty("config.code",Integer.class));

        // json.put("map", valuesMap);
        return json;
    }
    
    
}
