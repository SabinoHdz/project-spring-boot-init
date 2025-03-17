package com.springboot.webapp.springboot_webapp.exceptions;

public class TaskNotFoundException  extends RuntimeException{
    
    public TaskNotFoundException(String message) {
        super(message);
    }
}
