package com.loginPage.loginPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "home";
    }
    @GetMapping("/product/{productId}")
    public String getProductDetail(@PathVariable int productId, Model model) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + productId));

        model.addAttribute("product", product);
        return "product";
    }
   
}


