package com.example.goodreads.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.goodreads.model.Customer;
import com.example.goodreads.model.Product;
import com.example.goodreads.repository.CustomerJpaRepository;
import com.example.goodreads.repository.CustomerRepository;

import java.util.*;

@Service
public class CustomerJpaService implements CustomerRepository{

    @Autowired
    private CustomerJpaRepository cj;


    
    @Override
    public ArrayList<Customer> getCustomers(){
        List<Customer> lists = cj.findAll();
        ArrayList<Customer> result = new ArrayList<>(lists);
        return result;
    }

    @Override
    public Customer getCustomerById(int customerId){
        try{
            Customer c = cj.findById(customerId).get();
            return c;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Customer addCustomer(Customer customer){
        cj.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(int customerId, Customer customer){
        try{
            Customer oldOne = cj.findById(customerId).get();
            if(customer.getCustomerName() != null){
                oldOne.setCustomerName(customer.getCustomerName());
            }
            if(customer.getMobileNumber() != null){
                oldOne.setMobileNumber(customer.getMobileNumber());
            }
            cj.save(customer);
            return customer;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCustomer(int customerId){
        try{
            cj.deleteById(customerId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}