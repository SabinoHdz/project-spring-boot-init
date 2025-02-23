package com.springboot.webapp.springboot_webapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webapp.springboot_webapp.models.Product;
import com.springboot.webapp.springboot_webapp.repositories.ProductRepository;
import com.springboot.webapp.springboot_webapp.repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService {
    //private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();  
    
    //Injeccion de dependencias
    @Autowired
    private ProductRepository productRepository;
    
    // Constructor
    // public ProductServiceImpl(ProductRepository productRepository){
    //     this.productRepository = productRepository;
    // }
    
  

    // Metodo Setter
    // @Autowired
    // public void setProductRepository(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }

    @Override
    public  List<Product> findAll(){
        return productRepository.findAll().stream().map(p->{
            Double price = p.getPrice()*1.25d;
            Product product = new Product(p.getId(), p.getName(), p.getDescription(), price);
            return product;
        }).collect(Collectors.toList());
    }
    @Override
    public Product  findById( Long id){
       return productRepository.findById(id);
    }
 
    
}
