package com.springboot.webapp.springboot_webapp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.springboot.webapp.springboot_webapp.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private  final Faker faker = new Faker();
     private List<Product> data;
     
    public ProductRepositoryImpl() {
        data = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product = new Product();
            product.setId((long) i+1);
            product.setName(faker.commerce().productName());
            product.setDescription(faker.commerce().material());
            product.setPrice(faker.number().randomDouble(2, 10, 100));
            data.add(product);
        }
    }

    @Override
    public List<Product> findAll(){
        return data;
    }
    @Override
    public Product  findById( Long id){

        return data.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();

    }
    
}
