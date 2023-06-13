package com.proyectcens.springbootcens.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectcens.springbootcens.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;

	@GetMapping("/empresa")
	public String verPaginaEmpresa(){
		return "empresa";
	}

	@GetMapping("/ambitoDashboard")
	public String verPaginaAmbito(){
		return "ambitoDashboard";
	}

	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "index";
	}



}
