package com.example.springbootcrudexample.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//this is like a modal class
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {
    @Id       //to tell that id is primary key
    @GeneratedValue //TO autogenerate the id value
    private int id;
    private String name;
    private int quantity;
    private double price;

}
