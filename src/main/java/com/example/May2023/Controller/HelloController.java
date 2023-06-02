package com.example.May2023.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")  //name of the controller, used in URL mapping
public class HelloController {
    private static Logger log= LoggerFactory.getLogger(HelloController.class); //created logger object for hello controller class
    @GetMapping("/greet")
    public String sayHello(){
        log.info("Inside the Hello Controller");
        return "WELCOME TO THE SPRINGBOOT FRAMEWORK";
    }
}
