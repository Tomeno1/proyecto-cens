package com.proyectcens.springbootcens.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.proyectcens.springbootcens.modelo.ProcesoSello;

@Repository
public interface ProcesoSelloRepositorio extends JpaRepository<ProcesoSello, Long> {
    Optional<ProcesoSello> findById(Long id);
}
