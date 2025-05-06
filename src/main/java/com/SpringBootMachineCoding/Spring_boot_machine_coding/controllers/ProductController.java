package com.SpringBootMachineCoding.Spring_boot_machine_coding.controllers;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    public  ProductController(ProductService productService){
        this.productService = productService ;

    }
    @GetMapping("/{id}")
    public  Object  getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);

    }
}
