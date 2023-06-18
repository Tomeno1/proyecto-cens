package com.proyectcens.springbootcens.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectcens.springbootcens.controlador.dto.UsuarioRegistroDTO;
import com.proyectcens.springbootcens.modelo.Empresa;

import com.proyectcens.springbootcens.modelo.Usuario;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;

import com.proyectcens.springbootcens.servicio.UsuarioServicio;

@Controller
@RequestMapping
public class RegistroUsuarioControlador {

	@Autowired
	private EmpresaRepositorio empresaRepositorio;

	@Autowired
	private UsuarioServicio usuarioServicio;

	public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}

	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping("/crearUsuarioEmpresa")
	public String mostrarFormularioDeRegistro(Model model) {
		Optional<Empresa> ultimaEmpresaRegistrada = empresaRepositorio.findTopByOrderByFechaIngresoDesc();

		if (ultimaEmpresaRegistrada.isPresent()) {
			Empresa ultimaEmpresa = ultimaEmpresaRegistrada.get();
			Long ultimaEmpresaId = ultimaEmpresa.getId();

			List<Empresa> listaEmpresa = Arrays.asList(ultimaEmpresa);
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("listaEmpresa", listaEmpresa);
			model.addAttribute("ultimaEmpresaId", ultimaEmpresaId);
		} else {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("listaEmpresa", new ArrayList<Empresa>());
		}

		return "formRegistroUsuario";
	}

	@GetMapping("/crearUsuarioCens")
	public String mostrarFormularioDeRegistroCens(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formRegistroUsuariosCens";
	}

	@PostMapping("/guardarUsuarioEmpresa")
	public String registrarCuentaDeUsuarioEmpresa(@ModelAttribute("usuario") UsuarioRegistroDTO usuarioRegistroDTO) {
		Long idEmpresa = usuarioServicio.obtenerUltimaEmpresaId();
		usuarioServicio.guardarUsuarioEmpresa(usuarioRegistroDTO, idEmpresa);
		return "redirect:/crearEmpresa?exito";
	}

	@PostMapping("/guardarUsuarioCens")
	public String registrarCuentaDeUsuarioCens(@ModelAttribute("usuario") UsuarioRegistroDTO usuarioRegistroDTO) {
		String rolSeleccionado = usuarioRegistroDTO.getRol();
		usuarioRegistroDTO.setRol(rolSeleccionado);
		usuarioServicio.guardarUsuarioCens(usuarioRegistroDTO);
		return "redirect:/crearUsuarioCens?exito";
	}

}
