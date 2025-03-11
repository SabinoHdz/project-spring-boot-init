package com.springboot.webapp.springboot_webapp.services;

import java.util.List;
import java.util.Optional;

import com.springboot.webapp.springboot_webapp.models.domain.User;

public interface IUserService {
    List<User> findAll();   

    Optional<User> findById(Long id);

    
}
