package com.SpringBootMachineCoding.Spring_boot_machine_coding.controllers;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Product;
import com.SpringBootMachineCoding.Spring_boot_machine_coding.services.FakeProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


//    Fake product service
    FakeProductService fakeProductService;
    public  ProductController(FakeProductService fakeProductService){
        this.fakeProductService = fakeProductService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return fakeProductService.getProductById(id);

    }

    @GetMapping()
    public List<Product> getAllProductsAPI(){
        return  fakeProductService.getAllProducts();

    }

    @PutMapping("/update/{id}")
    public  Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return  fakeProductService.updateProduct(id , product);

    }
}
