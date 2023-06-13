package com.proyectcens.springbootcens.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.Usuario;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario guardar(Usuario registroUsuario, Empresa registroEmpresa);

    public List<Usuario> listarUsuarios();
    
}
