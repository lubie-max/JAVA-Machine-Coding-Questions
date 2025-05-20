package com.SpringBootMachineCoding.Spring_boot_machine_coding.services;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Product;

import javax.management.InstanceNotFoundException;
import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InstanceNotFoundException;

    List<Product> getAllProducts();
    Product updateProduct(Long id , Product product);

}