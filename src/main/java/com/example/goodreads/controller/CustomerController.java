package com.example.goodreads.controller;

import com.example.goodreads.model.Product;
import com.example.goodreads.model.Customer;
import com.example.goodreads.service.CustomerJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    @Autowired
    private CustomerJpaService cs;

    @GetMapping("/customers")
    public ArrayList<Customer> getCustomers(){
        return cs.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") int id){
        return cs.getCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        return cs.addCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
        return cs.updateCustomer(id, customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") int id){
        cs.deleteCustomer(id);
    }
 }
