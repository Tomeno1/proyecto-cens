package com.proyectcens.springbootcens.controlador;

import javax.annotation.security.PermitAll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PermitAll
public class LoginControlador {
    
    @GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
}
