package com.wipro.userms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;
import com.wipro.userms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/saveadmin")
    public String registerAdmin(@RequestBody User user) {
        return userService.registerAdmin(user);
    }

    @PostMapping("/saveuser")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "USER SUCCESSFULLY REGISTERED";
    }


    @PostMapping("/login")
    public Token login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/logout/{userId}")
    public String logout(@PathVariable int userId) {
        return userService.logout(userId) ? "Successfully Logged Out" : "LOGOUT FAILED";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "JWT AUTHENTICATION IS WORKING PROPERLY";
    }
}
