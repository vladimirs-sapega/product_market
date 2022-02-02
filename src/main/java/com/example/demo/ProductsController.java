package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }


    @PostMapping(value = "/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);

    }

    @PostMapping(value = "/savetotxt/{id}/{name}")
    public void saveToTxt(@PathVariable String id, @PathVariable String name) throws IOException {

        Product product = new Product();
        product.setId(id);
        product.setName(name);

        try (FileOutputStream f = new FileOutputStream("src/main/resources/products/myProducts.txt");
             PrintStream o = new PrintStream(f,true, StandardCharsets.UTF_8)) {

            o.write(product.toString().getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @PostMapping(value = "/products/v2/{id}/{name}/")
    public void addProduct2(@PathVariable String id, @PathVariable String name) {

        Product product = new Product();
        product.setId(id);
        product.setName(name);

        productService.addProduct(product);

    }
}