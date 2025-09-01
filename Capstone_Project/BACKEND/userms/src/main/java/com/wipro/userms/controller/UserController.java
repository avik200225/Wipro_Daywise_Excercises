package com.wipro.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;
import com.wipro.userms.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@Tag(name = "User Management", description = "APIs for managing users")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Register an admin user")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Admin registered"),
        @ApiResponse(responseCode = "400", description = "Invalid user data")
    })
    @PostMapping("/saveadmin")
    public String registerAdmin(@RequestBody User user) {
        return userService.registerAdmin(user);
    }

    @Operation(summary = "Register a normal user")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User registered"),
        @ApiResponse(responseCode = "400", description = "Invalid user data")
    })
    @PostMapping("/saveuser")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "USER SUCCESSFULLY REGISTERED";
    }

    @Operation(summary = "Login and get JWT token")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Login successful"),
        @ApiResponse(responseCode = "401", description = "Bad credentials")
    })
    @PostMapping("/login")
    public Token login(@RequestBody User user) {
        return userService.login(user);
    }

    @Operation(summary = "Logout a user by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Logout status returned")
    })
    @PostMapping("/logout/{userId}")
    public String logout(@PathVariable int userId) {
        return userService.logout(userId) ? "Successfully Logged Out" : "LOGOUT FAILED";
    }

    @Operation(summary = "Get all users")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @Operation(summary = "Test endpoint (JWT required)")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/test")
    public String testEndpoint() {
        return "JWT AUTHENTICATION IS WORKING PROPERLY";
    }
}
