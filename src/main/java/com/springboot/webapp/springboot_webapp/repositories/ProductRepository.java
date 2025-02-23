package com.springboot.webapp.springboot_webapp.repositories;

import java.util.List;

import com.springboot.webapp.springboot_webapp.models.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
