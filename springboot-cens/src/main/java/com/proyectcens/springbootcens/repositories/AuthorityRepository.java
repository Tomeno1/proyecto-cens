package com.proyectcens.springbootcens.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectcens.springbootcens.model.Authority;
import com.proyectcens.springbootcens.utils.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
    Optional<Authority> findByName(AuthorityName name);
}
