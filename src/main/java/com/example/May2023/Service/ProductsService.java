package com.example.May2023.Service;

import com.example.May2023.Model.Products;
import com.example.May2023.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository pRepo;

    public List<Products> getAllProducts(){
        return pRepo.findAll();
    }
}
