package com.example.May2023.Controller;

import com.example.May2023.Model.Products;
import com.example.May2023.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsService pService;

    @GetMapping("/all")
    public List<Products> getAllProducts(){
        return pService.getAllProducts();
    }
}
