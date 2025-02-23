package com.springboot.webapp.springboot_webapp.services;

import java.util.List;

import com.springboot.webapp.springboot_webapp.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    
}
