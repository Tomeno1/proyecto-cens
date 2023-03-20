package com.proyectcens.springbootcens.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/demo")
    public String showDemo(){
        return "Hola mundo";
    }
}
