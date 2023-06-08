package com.proyectcens.springbootcens.servicio;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.controlador.dto.UsuarioRegistroDTO;
import com.proyectcens.springbootcens.modelo.Rol;
import com.proyectcens.springbootcens.modelo.RolEnum;
import com.proyectcens.springbootcens.modelo.Usuario;
import com.proyectcens.springbootcens.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;

    }

    @Override
public Usuario guardar(UsuarioRegistroDTO registroDTO) {
    Rol rol = new Rol(RolEnum.ROLE_ADMIN);
    Usuario usuario = new Usuario(registroDTO.getNombre(),
            registroDTO.getApellido(), registroDTO.getEmail(),
            passwordEncoder.encode(registroDTO.getPassword()),
            registroDTO.getRut(), registroDTO.getTelefono(), null, rol);

    return usuarioRepositorio.save(usuario);
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepositorio.findByEmail(username);
    if (usuario == null) {
        throw new UsernameNotFoundException("Usuario o contraseña inválidos");
    }
    return User.builder()
            .username(usuario.getEmail())
            .password(usuario.getPassword())
            .authorities(mapearAutoridadesRoles(usuario.getRol().getNombre()))
            .build();
}


    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(RolEnum rol) {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
}
