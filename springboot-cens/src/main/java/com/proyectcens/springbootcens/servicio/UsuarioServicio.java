package com.proyectcens.springbootcens.servicio;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.proyectcens.springbootcens.controlador.dto.UsuarioRegistroDTO;
import com.proyectcens.springbootcens.modelo.Usuario;



public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
