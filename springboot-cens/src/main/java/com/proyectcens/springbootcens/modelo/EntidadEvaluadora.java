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
@Table(name = "entidad_evaluadora")
public class EntidadEvaluadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "entidadEvaluadora")
    private List<Ambito> ambitos;

    // Constructores

    public EntidadEvaluadora() {
    }

    public EntidadEvaluadora(Long id, String nombre, List<Ambito> ambitos) {
        this.id = id;
        this.nombre = nombre;
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

    public List<Ambito> getAmbitos() {
        return ambitos;
    }

    public void setAmbitos(List<Ambito> ambitos) {
        this.ambitos = ambitos;
    }

}
