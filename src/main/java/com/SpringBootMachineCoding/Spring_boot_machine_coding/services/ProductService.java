package com.SpringBootMachineCoding.Spring_boot_machine_coding.services;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Product;

public interface ProductService {
    Product getProductById(Long id);

}