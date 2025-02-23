package com.springboot.webapp.springboot_webapp.controllers.dependencieInjection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springboot_webapp.models.Product;
import com.springboot.webapp.springboot_webapp.services.ProductService;
import com.springboot.webapp.springboot_webapp.services.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class SomeController {
    //private ProductServiceImpl productService = new ProductServiceImpl();
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }
    
}
