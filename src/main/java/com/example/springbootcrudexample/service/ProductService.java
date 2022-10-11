package com.example.springbootcrudexample.service;

import com.example.springbootcrudexample.entity.Product;
import com.example.springbootcrudexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //productservice will talk to the productrepository. so we need to inject it

    @Autowired
    public ProductRepository repository;

    //post method to save data to database
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    //post method to save data to database
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //get method to fetch all data from db
    public List<Product> getProducts(){
        return repository.findAll();
    }

    //get method to fetch specific data based on some condition
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    //get method to fetch specific data based on name
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //delete a product based on id
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product deleted"+id;
    }

    //to update the product
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
