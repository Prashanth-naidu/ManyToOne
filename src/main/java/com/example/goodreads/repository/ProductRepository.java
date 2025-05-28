package com.example.goodreads.repository;

import java.util.ArrayList;

import com.example.goodreads.model.Product;
import com.example.goodreads.model.Customer;


public interface ProductRepository {
    ArrayList<Product> getProducts();

    Product getProductById(int productId);

    Product addProduct(Product product);

    Product updateProduct(int productId, Product product);

    void deleteProduct(int productId);

    Customer getProductCustomer(int productId);
}
