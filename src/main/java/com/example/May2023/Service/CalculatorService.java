package com.example.May2023.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double divide(double first, double second){
        System.out.println("Inside Calculator Service");
        return first/second;
    }

    public double add(double first, double second){
        System.out.println("Inside Calculator Service");
        return first+second;
    }

    public double sub(double first, double second){
        System.out.println("Inside Calculator Service");
        return first-second;
    }

    public double mul(double first, double second){
        System.out.println("Inside Calculator Service");
        return first*second;
    }

    public double mod(double first, double second){
        System.out.println("Inside Calculator Service");
        return first%second;
    }

    public double si(double p, double r, double t){
        System.out.println("Inside Calculator Service");
        return p*r*t/100;
    }

    public double ci(double p, double r, double n, double t){
        System.out.println("Inside Calculator Service");
        double amount= p * Math.pow(1 + (r / n), n * t);
        return amount-p;
    }

}
