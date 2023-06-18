package com.proyectcens.springbootcens.servicio;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.proyectcens.springbootcens.controlador.dto.UsuarioRegistroDTO;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.Rol;
import com.proyectcens.springbootcens.modelo.Usuario;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;
import com.proyectcens.springbootcens.repositorio.RolRepositorio;
import com.proyectcens.springbootcens.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private EmpresaRepositorio empresaRepositorio;
    @Autowired
    private RolRepositorio rolRepositorio;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario guardarUsuarioEmpresa(UsuarioRegistroDTO usuarioRegistroDTO, Long idEmpresa) {
        Empresa empresa = empresaRepositorio.findById(idEmpresa).orElse(null);
        Usuario usuario = new Usuario(usuarioRegistroDTO.getNombre(), usuarioRegistroDTO.getApellido(),
                usuarioRegistroDTO.getEmail(), passwordEncoder.encode(usuarioRegistroDTO.getPassword()),
                usuarioRegistroDTO.getRut(), usuarioRegistroDTO.getTelefono(), empresa);

        return usuarioRepositorio.save(usuario);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRol()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Long obtenerUltimaEmpresaId() {
        Optional<Empresa> ultimaEmpresaRegistrada = empresaRepositorio.findTopByOrderByFechaIngresoDesc();
        return ultimaEmpresaRegistrada.map(Empresa::getId).orElse(null);
    }

    @Override
    public List<Empresa> obtenerListaEmpresa() {
        return empresaRepositorio.findAll();
    }

    @Override
    public Usuario guardarUsuarioCens(UsuarioRegistroDTO usuarioRegistroDTO) {
        Rol rol = new Rol(usuarioRegistroDTO.getRol());
        rol = rolRepositorio.save(rol);
        Usuario usuario = new Usuario(usuarioRegistroDTO.getNombre(), usuarioRegistroDTO.getApellido(),
                usuarioRegistroDTO.getEmail(), passwordEncoder.encode(usuarioRegistroDTO.getPassword()),
                usuarioRegistroDTO.getRut(), usuarioRegistroDTO.getTelefono(), Arrays.asList(rol));
                return usuarioRepositorio.save(usuario);
    }
}
