package com.proyectcens.springbootcens.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectcens.springbootcens.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	public Usuario findByEmail (String email);

	

}
