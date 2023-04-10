package com.proyectcens.springbootcens.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerLogin {

    @GetMapping("/formularioLogin")
    public String showLogin() {
        return "index.html";
    }
}
