package com.springboot.webapp.springboot_webapp.controllers.errores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springboot_webapp.exceptions.UserNotFoundException;
import com.springboot.webapp.springboot_webapp.models.domain.User;
import com.springboot.webapp.springboot_webapp.services.IUserService;
import com.springboot.webapp.springboot_webapp.services.UserServiceImpl;

@RestController
@RequestMapping("/app")
public class ErrorController {
    @Autowired
    private IUserService userService;
    @GetMapping("/error")
    public String error() {
        int value = Integer.parseInt("S");
        System.out.println("value: " + value);
        return "status 200";
    }

    @GetMapping("/show/{id}")
    public User showUser(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("Error: el usuario no exite"));
        return user;
// Optional<User> userOptional = userService.findById(id);
// if (userOptional.isEmpty()) {
// // throw new UserNotFoundException("Error: el usuario no exite");
// return ResponseEntity.notFound().build();
// }
// // user.getName();
// return ResponseEntity.ok(userOptional.orElseThrow());
    }
}
