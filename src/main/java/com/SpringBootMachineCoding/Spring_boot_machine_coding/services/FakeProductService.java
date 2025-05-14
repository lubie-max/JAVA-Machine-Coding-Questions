package com.SpringBootMachineCoding.Spring_boot_machine_coding.services;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Product;
import org.springframework.stereotype.Service;

@Service
public class FakeProductService implements ProductService {
//    public Object getProductById(long id){
//        return """
//                {
//                "category" : "Electronics",
//                "price" : 1200 ,
//                "title" : Moto2060
//                }
//
//
//                """;
//    }


    @Override
    public Product getProductById(Long id) {
        return null;
    }
}
