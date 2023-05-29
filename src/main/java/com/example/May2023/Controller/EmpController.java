package com.example.May2023.Controller;

import com.example.May2023.Model.Emp;
import com.example.May2023.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService eService;

    @GetMapping("/all")
    public List<Emp> getAllEmpDetails(){
        return eService.getAllEmpDetails();
    }
}
