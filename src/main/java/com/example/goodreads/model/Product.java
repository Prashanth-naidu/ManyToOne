package com.example.goodreads.model;

import javax.persistence.*;
import com.example.goodreads.model.Customer;

@Entity
@Table(name="product")
public class Product{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @ManyToOne
    @JoinColumn(name="customerid")
    private Customer customer;

    public Product(){}

    public Product(int id, String name, int price, Customer customer){
        this.id = id;
        this.name = name;
        this.price = price;
        this.customer = customer;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}
