package com.example.goodreads.controller;

import com.example.goodreads.service.ProductJpaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.goodreads.model.Product;
import com.example.goodreads.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
class ProductController {

    @Autowired
    private ProductJpaService pj;

    @GetMapping("/products")
    public ArrayList<Product> getProducts(){
        return pj.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") int id){
        return pj.getProductById(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return pj.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") int id, Product product){
        return pj.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") int id){
        pj.deleteProduct(id);
    }

    @GetMapping("/products/{id}/customer")
    public Customer getProductCustomer(@PathVariable("id") int id){
        return pj.getProductCustomer(id);
    }
}