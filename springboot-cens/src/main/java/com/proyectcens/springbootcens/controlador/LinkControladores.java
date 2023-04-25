package com.proyectcens.springbootcens.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkControladores {
    @GetMapping("/empresa")
	public String linkEmpresa() {
		return "empresa";
	}

	@GetMapping("/index")
	public String linkIndex(){
		return "index";
	}

	@GetMapping("/registrarEmpresa")
	public String linkRegistrarEmpresa(){
		return "registrarEmpresa";
	}
}
