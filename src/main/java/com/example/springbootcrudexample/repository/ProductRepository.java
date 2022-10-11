package com.example.springbootcrudexample.repository;

import com.example.springbootcrudexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> { //we have to specify our modal name and datatype of our primary key
        Product findByName(String name);

}
