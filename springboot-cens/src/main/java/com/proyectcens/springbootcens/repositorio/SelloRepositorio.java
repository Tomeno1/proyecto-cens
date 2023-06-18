package com.proyectcens.springbootcens.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectcens.springbootcens.modelo.Sello;

@Repository
public interface SelloRepositorio extends JpaRepository<Sello, Long> {
    Optional<Sello> findById(Long id);

    Optional<Sello> findByNombre(String nombre);
}
