package com.example.May2023.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")  //name of the controller, used in URL mapping
public class HelloController {
    @GetMapping("/greet")
    public String sayHello(){
        return "WELCOME TO THE SPRINGBOOT FRAMEWORK";
    }
}
