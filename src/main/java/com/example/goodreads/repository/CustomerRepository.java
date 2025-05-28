package com.example.goodreads.repository;

import com.example.goodreads.model.Customer;

import java.util.ArrayList;

public interface CustomerRepository {

    ArrayList<Customer> getCustomers();

    Customer getCustomerById(int customerId);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(int customerId, Customer customer);

    void deleteCustomer(int customerId);
}
