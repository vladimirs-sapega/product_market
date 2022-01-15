package com.example.demo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {


    private List<Product> products = new ArrayList<>( Arrays.asList(
            new Product("1", "Iphone", "400"),
            new Product("2", "Iwatch", "500"),
            new Product("3", "Ipad", "600")
        ));

    public List<Product> getAllProducts() {
        return products;
    }
    public Product getProduct(String id){

        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        products.add(product);
    }
}




