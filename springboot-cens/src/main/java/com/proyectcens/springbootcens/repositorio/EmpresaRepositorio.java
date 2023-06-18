package com.proyectcens.springbootcens.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectcens.springbootcens.modelo.Empresa;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {


    Optional<Empresa> findByRut(String rut);

    Optional<Empresa> findById(Long id);

    Optional<Empresa> findTopByOrderByFechaIngresoDesc();

}
