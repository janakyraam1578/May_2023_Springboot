package com.example.May2023;

//import com.example.May2023.Repository.ProductsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class May2023Application {

	public static void main(String[] args) {
		SpringApplication.run(May2023Application.class, args);
	}

}
