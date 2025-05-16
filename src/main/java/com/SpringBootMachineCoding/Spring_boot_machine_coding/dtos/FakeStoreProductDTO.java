package com.SpringBootMachineCoding.Spring_boot_machine_coding.dtos;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {


    Long id ;
    String title;
    Double price;
    String description;
    String category;


}
