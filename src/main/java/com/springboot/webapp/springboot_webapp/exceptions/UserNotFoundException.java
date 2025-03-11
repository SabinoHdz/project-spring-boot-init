package com.springboot.webapp.springboot_webapp.exceptions;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String message) {
        super(message);
    }

}
