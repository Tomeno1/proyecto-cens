package com.proyectcens.springbootcens.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.Usuario;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;
import com.proyectcens.springbootcens.servicio.EmpresaServicio;

@Controller
public class Controladores {

	@Autowired
	private EmpresaServicio empresaServicio;
	@Autowired
	private EmpresaRepositorio empresaRepositorio;

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/")
	public String showIndexPage(Model model) {
		Optional<Empresa> ultimaEmpresaRegistrada = empresaRepositorio.findTopByOrderByFechaIngresoDesc();
		long cantidadEmpresas = empresaRepositorio.count();

		if (ultimaEmpresaRegistrada.isPresent()) {
			Empresa ultimaEmpresa = ultimaEmpresaRegistrada.get();
			Long ultimaEmpresaId = ultimaEmpresa.getId();

			model.addAttribute("usuario", new Usuario());
			model.addAttribute("listaEmpresa", Arrays.asList(ultimaEmpresa));
			model.addAttribute("ultimaEmpresaId", ultimaEmpresaId);
			model.addAttribute("cantidadEmpresas", cantidadEmpresas);
		} else {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("listaEmpresa", new ArrayList<Empresa>());
		}

		return "index";
	}

}
