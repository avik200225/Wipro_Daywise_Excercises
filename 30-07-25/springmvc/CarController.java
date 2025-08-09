package com.wipro.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.springmvc.service.CarService;

@Controller
@RequestMapping("/prod")
public class CarController {

    @Autowired
    CarService prodService;

    @GetMapping("/list")
    public String showCarList(Model model) {
        model.addAttribute("prodList", prodService.getCarList());
        return "carlist"; // Resolved to /WEB-INF/views/carlist.jsp
    }
}
