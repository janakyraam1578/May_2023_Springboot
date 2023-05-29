package com.example.May2023.Controller;

import com.example.May2023.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {
    @Autowired //Dependency Injection
    CalculatorService cService;
    @GetMapping("/divide/{firstValue}/{secondValue}")
    public ResponseEntity<Object> divide(
            @PathVariable("firstValue") double firstNumber,
            @PathVariable("secondValue") double secondNumber
    ){
        System.out.println("Inside Calculator Controller");
        if(secondNumber == 0){
            return new ResponseEntity<>("Second Value is Zero, division operation cannot be performed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cService.divide(firstNumber, secondNumber), HttpStatus.OK);
    }

    @GetMapping("/add/{firstValue}/{secondValue}")
    public ResponseEntity<Object> add(
            @PathVariable("firstValue") double firstNumber,
            @PathVariable("secondValue") double secondNumber
    ){
        System.out.println("Inside Calculator Controller");
        return new ResponseEntity<>(cService.add(firstNumber, secondNumber), HttpStatus.OK);
    }

    @GetMapping("/sub/{firstValue}/{secondValue}")
    public ResponseEntity<Object> sub(
            @PathVariable("firstValue") double firstNumber,
            @PathVariable("secondValue") double secondNumber
    ){
        System.out.println("Inside Calculator Controller");
        return new ResponseEntity<>(cService.sub(firstNumber, secondNumber), HttpStatus.OK);
    }

    @GetMapping("/mul/{firstValue}/{secondValue}")
    public ResponseEntity<Object> mul(
            @PathVariable("firstValue") double firstNumber,
            @PathVariable("secondValue") double secondNumber
    ){
        System.out.println("Inside Calculator Controller");
        return new ResponseEntity<>(cService.mul(firstNumber, secondNumber), HttpStatus.OK);
    }

    @GetMapping("/mod/{firstValue}/{secondValue}")
    public ResponseEntity<Object> mod(
            @PathVariable("firstValue") double firstNumber,
            @PathVariable("secondValue") double secondNumber
    ){
        System.out.println("Inside Calculator Controller");
        return new ResponseEntity<>(cService.mod(firstNumber, secondNumber), HttpStatus.OK);
    }

    @GetMapping("/si/{pValue}/{rValue}/{tValue}")
    public ResponseEntity<Object> si(
            @PathVariable("pValue") double p,
            @PathVariable("rValue") double r,
            @PathVariable("tValue") double t
    ){
        System.out.println("Inside Calculator Controller");
        return new ResponseEntity<>(cService.si(p, r, t), HttpStatus.OK);
    }

    @GetMapping("/ci/{pValue}/{rValue}/{nValue}/{tValue}")
    public ResponseEntity<Object> ci(
            @PathVariable("pValue") double p,
            @PathVariable("rValue") double r,
            @PathVariable("rValue") double n,
            @PathVariable("tValue") double t
    ){
        System.out.println("Inside Calculator Controller");
        return new ResponseEntity<>(cService.ci(p, r, n, t), HttpStatus.OK);
    }
}
