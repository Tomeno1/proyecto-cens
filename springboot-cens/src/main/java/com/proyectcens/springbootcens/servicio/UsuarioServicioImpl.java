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

import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.Rol;
import com.proyectcens.springbootcens.modelo.RolEnum;
import com.proyectcens.springbootcens.modelo.Usuario;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;
import com.proyectcens.springbootcens.repositorio.RolRepositorio;
import com.proyectcens.springbootcens.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;
    private EmpresaRepositorio empresaRepositorio;
    private RolRepositorio rolRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio, EmpresaRepositorio empresaRepositorio,
            RolRepositorio rolRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.empresaRepositorio = empresaRepositorio;
        this.rolRepositorio = rolRepositorio;
    }

    @Override
    public Usuario guardar(Usuario registroUsuario, Empresa registroEmpresa) {
        Rol rol = new Rol(RolEnum.ROLE_USER);
        rol = rolRepositorio.save(rol);
        Empresa empresa = empresaRepositorio.getById(registroEmpresa.getId());

        // Guardar la instancia transitoria de Empresa

        // Crear el objeto Usuario con la instancia persistida de Empresa
        Usuario usuario = new Usuario(registroUsuario.getId(), registroUsuario.getNombre(),
                registroUsuario.getApellido(),
                registroUsuario.getEmail(), passwordEncoder.encode(registroUsuario.getPassword()),
                registroUsuario.getRut(), registroUsuario.getTelefono(), empresa, rol);

        // Guardar el Usuario con la relación a la Empresa persistida
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
