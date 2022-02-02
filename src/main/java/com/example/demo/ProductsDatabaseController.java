package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsDatabaseController {
    @Autowired
    private ProductsRepository productsRepo;

    @GetMapping("/products")
    public String listAll(Model model){
        List<Product> listProducts = productsRepo.findAll();
        model.addAttribute("listProducts", listProducts);

        return "products";
    }
}
