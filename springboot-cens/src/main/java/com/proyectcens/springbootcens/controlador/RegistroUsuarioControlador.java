package com.proyectcens.springbootcens.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.Usuario;
import com.proyectcens.springbootcens.servicio.UsuarioServicio;

@Controller
@RequestMapping
public class RegistroUsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@ModelAttribute("usuario")
	public Usuario retornarNuevoUsuarioRegistroDTO() {
		return new Usuario();
	}

	@GetMapping("/crearUsuario")
	public String mostrarFormularioDeRegistro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formRegistroUsuarios";
	}

	@PostMapping("/guardarUsuario")
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") Usuario registroUsuario,
			@ModelAttribute("empresa") Empresa registroEmpresa) {
		usuarioServicio.guardar(registroUsuario, registroEmpresa);
		return "redirect:/crearUsuario?exito";
	}

}

/*
 * @ModelAttribute("usuario")
 * public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
 * return new UsuarioRegistroDTO();
 * }
 * 
 * @GetMapping
 * public String mostrarFormularioDeRegistro(Model model) {
 * model.addAttribute("usuario", new Usuario());
 * return "formRegistroUsuarios";
 * }
 * 
 * @PostMapping
 * public String registrarCuentaDeUsuario(@ModelAttribute("usuario")
 * UsuarioRegistroDTO registroDTO, @ModelAttribute("empresa") EmpresaRegistroDTO
 * empresaDTO) {
 * usuarioServicio.guardar(registroDTO, empresaDTO);
 * return "redirect:/registroUsuarios?exito";
 * }
 * 
 */