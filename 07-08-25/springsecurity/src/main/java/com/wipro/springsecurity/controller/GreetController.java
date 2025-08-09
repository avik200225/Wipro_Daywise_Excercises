package com.wipro.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello without authentication!";
    }

    @GetMapping("/secure1")
    public String secure1() {
        return "This is a secured 1";
    }

    @GetMapping("/secure2")
    public String secure2() {
        return "This is a secured 2";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin requires authentication)";
    }
}
