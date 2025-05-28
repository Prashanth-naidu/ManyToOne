package com.example.goodreads.repository;

import com.example.goodreads.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer>{
    
}