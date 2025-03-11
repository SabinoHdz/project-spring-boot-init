package com.springboot.webapp.springboot_webapp.controllers.errores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ErrorController {
    
    @GetMapping("/error")
    public String error() {
        int value =100/0;
        return "status 200";
    }
}
