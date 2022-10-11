package com.example.springbootcrudexample.controller;

import com.example.springbootcrudexample.entity.Product;
import com.example.springbootcrudexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//this controller will talk to the service class
@RestController
public class ProductController {


    //for this we need to inject service in controller class
        @Autowired
        private ProductService service;


        //post method to add product in db

        @PostMapping("/addProduct")
        public Product addProduct(@RequestBody Product product) { //we need to annotate the requets body so that input json can be parsed to product object
            return service.saveProduct(product);
        }

        @PostMapping("/addProducts")
        public List<Product> addProducts(@RequestBody List<Product> products) {
            return service.saveProducts(products);
        }

        @GetMapping("/products")
        public List<Product> findAllProducts() {
            return service.getProducts();
        }

        @GetMapping("/productById/{id}")
        public Product findProductById(@PathVariable int id) { //@pathVariable or we can use @RequestParameter to give the field in the request get url
            return service.getProductById(id);
        }

        @GetMapping("/productByName/{name}")
        public Product findProductByName(@PathVariable String name) {
            return service.getProductByName(name);
        }

        @PutMapping("/update")
        public Product updateProduct(@RequestBody Product product) {
            return service.updateProduct(product);
        }

        @DeleteMapping("/delete/{id}")
        public String deleteProduct(@PathVariable int id) {
            return service.deleteProduct(id);
        }
}
