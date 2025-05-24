package com.SpringBootMachineCoding.Spring_boot_machine_coding.global_exception_handler;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException pe){
        return new ResponseEntity<>(pe.getMessage() , HttpStatus.NOT_FOUND);
    }
}
