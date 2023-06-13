package com.proyectcens.springbootcens.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectcens.springbootcens.modelo.Ambito;

@Repository
public interface AmbitoRepositorio extends JpaRepository<Ambito, Long> {

}