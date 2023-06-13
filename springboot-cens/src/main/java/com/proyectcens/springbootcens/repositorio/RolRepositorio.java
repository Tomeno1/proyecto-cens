package com.proyectcens.springbootcens.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectcens.springbootcens.modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long> {
    
}
