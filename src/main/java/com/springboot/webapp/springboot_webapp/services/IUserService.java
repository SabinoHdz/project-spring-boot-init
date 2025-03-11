package com.springboot.webapp.springboot_webapp.services;

import java.util.List;

import com.springboot.webapp.springboot_webapp.models.domain.User;

public interface IUserService {
    List<User> findAll();   
    User findById(Long id);

    
}
