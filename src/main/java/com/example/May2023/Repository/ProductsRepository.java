package com.example.May2023.Repository;

import com.example.May2023.Model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products, Integer> {
}
