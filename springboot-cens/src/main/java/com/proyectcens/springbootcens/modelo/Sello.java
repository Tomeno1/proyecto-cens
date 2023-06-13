package com.proyectcens.springbootcens.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sello")
public class Sello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "sello")
    private List<Ambito> ambitos;

    // Constructores

    public Sello() {
    }

    public Sello(Long id, String nombre, String descripcion, List<Ambito> ambitos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ambitos = ambitos;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Ambito> getAmbitos() {
        return ambitos;
    }

    public void setAmbitos(List<Ambito> ambitos) {
        this.ambitos = ambitos;
    }

}
