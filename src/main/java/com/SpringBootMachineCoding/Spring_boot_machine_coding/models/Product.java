package com.SpringBootMachineCoding.Spring_boot_machine_coding.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class Product {
    Long id;
    String description ;
    String name;
    Double price ;
    Category category;
}
