package com.example.demo;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
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
}



