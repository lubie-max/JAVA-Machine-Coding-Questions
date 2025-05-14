package com.SpringBootMachineCoding.Spring_boot_machine_coding.controllers;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.services.FakeProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

//Actual product service
//    ProductService productService;
//    public  ProductController(ProductService productService){
//        this.productService = productService ;
//
//    }

//    Fake product service
    FakeProductService fakeProductService;
    public  ProductController(FakeProductService fakeProductService){
        this.fakeProductService = fakeProductService;
    }


    @GetMapping("/{id}")
    public  Object  getProductById(@PathVariable("id") Long id){
        return fakeProductService.getProductById(id);

    }
}
