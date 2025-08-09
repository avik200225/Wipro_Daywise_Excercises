package com.wipro.dto.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.DtoMobileApplication;

@RestController
public class DtoMobileController {

  @PostMapping("/mobile")
  public String createMobile(@RequestBody DtoMobileApplication mobile) {
      System.out.println("POST Received: " + mobile);
      return "Mobile created";
  }
  @GetMapping("/mobile")
  public String getMobile() {
      System.out.println("GET Received");
      return "Fetching mobile info";
  }
  @PutMapping("/mobile")
  public String updateMobile(@RequestBody DtoMobileApplication mobile) {
      System.out.println("PUT Received: " + mobile);
      return "Mobile updated";
  }
  @DeleteMapping("/mobile")
  public String deleteMobile() {
      System.out.println("DELETE Received");
      return "Mobile deleted";
  }
 }


