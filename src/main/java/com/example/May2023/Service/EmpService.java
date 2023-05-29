package com.example.May2023.Service;

import com.example.May2023.Model.Emp;
import com.example.May2023.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    EmpRepository eRepo;
    public List<Emp> getAllEmpDetails(){
        return eRepo.findAll(); //select * from emp;
    }
}
