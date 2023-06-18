package com.proyectcens.springbootcens.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controladores {

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}

}
