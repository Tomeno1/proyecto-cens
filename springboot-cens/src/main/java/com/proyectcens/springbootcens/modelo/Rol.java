package com.proyectcens.springbootcens.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolEnum nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolEnum getNombre() {
        return nombre;
    }

    public void setNombre(RolEnum nombre) {
        this.nombre = nombre;
    }

    public Rol() {
    }

    public Rol(RolEnum nombre) {
        this.nombre = nombre;
    }
}
