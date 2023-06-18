package com.proyectcens.springbootcens.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.proyectcens.springbootcens.controlador.dto.UsuarioRegistroDTO;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.Usuario;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario guardarUsuarioEmpresa(UsuarioRegistroDTO usuarioRegistroDTO, Long idEmpresa);

    public Usuario guardarUsuarioCens(UsuarioRegistroDTO usuarioRegistroDTO);

    Long obtenerUltimaEmpresaId();

    public List<Usuario> listarUsuarios();

    public List<Empresa> obtenerListaEmpresa();

}
