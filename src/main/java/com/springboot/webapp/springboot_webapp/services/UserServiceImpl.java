package com.springboot.webapp.springboot_webapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.webapp.springboot_webapp.models.domain.User;

@Service
public class UserServiceImpl implements IUserService{
    private List <User> users;
    public UserServiceImpl() {
     this.users= new ArrayList<>();
     this.users.add(new User(1L, "John", "Doe"));
        this.users.add(new User(2L, "Jane", "Doe"));
        this.users.add(new User(3L, "Tom", "Doe"));
        this.users.add(new User(4L, "Jerry", "Doe"));
        this.users.add(new User(5L, "Alice", "Doe"));
    }
    
    @Override
    public List<User> findAll() {
       return users;
    }

    @Override
    public User findById(Long id) {
     return  users.stream().filter(u->u.getId().equals(id)).findFirst().orElse(null);
    }
    
}
