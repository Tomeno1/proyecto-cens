package com.proyectcens.springbootcens.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @PostMapping("/demo")
    public String showDemo() {
        return "Hola mundo, estamos probando esto";
    }
}
