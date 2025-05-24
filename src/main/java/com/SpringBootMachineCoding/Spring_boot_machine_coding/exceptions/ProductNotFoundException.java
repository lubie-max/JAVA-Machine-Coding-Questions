package com.SpringBootMachineCoding.Spring_boot_machine_coding.exceptions;

public class ProductNotFoundException extends  RuntimeException{
    public ProductNotFoundException(String msg){
        super(msg);
    }
}
