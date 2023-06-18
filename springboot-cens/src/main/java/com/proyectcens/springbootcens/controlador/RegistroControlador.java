package com.proyectcens.springbootcens.controlador;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistroControlador {



	@GetMapping("/empresa")
	public String verPaginaEmpresa(){
		return "empresa";
	}

	@GetMapping("/ambitoDashboard")
	public String verPaginaAmbito(){
		return "ambitoDashboard";
	}


}
