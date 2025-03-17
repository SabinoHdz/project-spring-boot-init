package com.springboot.webapp.springboot_webapp.exceptions;

public class ProjectNotFoundException extends RuntimeException{
    
    public ProjectNotFoundException(String message) {
        super(message);
    }
    
}
