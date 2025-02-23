package com.springboot.webapp.springboot_webapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.springboot.webapp.springboot_webapp.models.dto.ParamDto;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {
    
@GetMapping("/index")
public ParamDto foo(@RequestParam(required = false,defaultValue = "Endpoint Params") String message){
    
    ParamDto paramDto = new ParamDto();
    paramDto.setMessage(message);
    return paramDto;
}

@GetMapping("/bar")
public ParamDto bar(@RequestParam(required = false) String text,@RequestParam(required=false) Integer code){
       ParamDto parameters = new ParamDto();
       parameters.setMessage(text);
       parameters.setCode(code);
       return parameters;
  
}

}
