package com.SpringBootMachineCoding.Spring_boot_machine_coding.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping()
    public  String checkHealth(){
        return "All is well";
    }
}
