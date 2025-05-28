package com.example.goodreads.service;

import com.example.goodreads.model.Product;
import com.example.goodreads.model.Customer;
import com.example.goodreads.repository.ProductJpaRepository;
import com.example.goodreads.repository.CustomerJpaRepository;
import com.example.goodreads.repository.ProductRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ProductJpaService implements ProductRepository{

    @Autowired
    private ProductJpaRepository sj;

    @Autowired
    private CustomerJpaRepository cj;

    @Override
    public ArrayList<Product> getProducts(){
        List<Product> lists = sj.findAll();
        ArrayList<Product> result = new ArrayList<>(lists);
        return result;
    }

    @Override
    public Product getProductById(int productId){
        try{
            Product product = sj.findById(productId).get();
            return product;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product){
        Customer customer = product.getCustomer();
        int id = customer.getCustomerId();
        try{
            Customer c = cj.findById(id).get();
            product.setCustomer(c);
            sj.save(product);
            return product;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product updateProduct(int productId, Product product){
        try{
            Product oldOne = sj.findById(productId).get();
            if(product.getName() != null){
                oldOne.setName(product.getName());
            }
            if(product.getPrice() != 0){
                oldOne.setPrice(product.getPrice());
            }
            if(product.getCustomer() != null){
                Customer customer = product.getCustomer();
                int id = customer.getCustomerId();
                Customer newCustomer = cj.findById(id).get();
                oldOne.setCustomer(newCustomer);
            }else{
                oldOne.setCustomer(null);
            }
            sj.save(oldOne);
            return oldOne;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProduct(int productId){
        try{
            sj.deleteById(productId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Customer getProductCustomer(int productId){
        try{
            Product p = sj.findById(productId).get();
            return p.getCustomer();
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}