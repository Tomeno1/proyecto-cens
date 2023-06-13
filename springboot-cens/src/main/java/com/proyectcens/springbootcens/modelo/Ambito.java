package com.proyectcens.springbootcens.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ambito")
public class Ambito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "sello_id", referencedColumnName = "id") // Nombre de la columna que representa la relación con
                                                                // Sello
    private Sello sello;

    @ManyToOne
    @JoinColumn(name = "entidad_evaluadora_id", referencedColumnName = "id")
    private EntidadEvaluadora entidadEvaluadora;

    @OneToMany(mappedBy = "ambito")
    private List<SubAmbito> subAmbitos = new ArrayList<>();

    // Constructores

    public Ambito() {
    }

    public Ambito(Long id, String nombre, Sello sello, EntidadEvaluadora entidadEvaluadora,
            List<SubAmbito> subAmbitos) {
        this.id = id;
        this.nombre = nombre;
        this.sello = sello;
        this.entidadEvaluadora = entidadEvaluadora;
        this.subAmbitos = subAmbitos;
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

    public Sello getSello() {
        return sello;
    }

    public void setSello(Sello sello) {
        this.sello = sello;
    }

    public EntidadEvaluadora getEntidadEvaluadora() {
        return entidadEvaluadora;
    }

    public void setEntidadEvaluadora(EntidadEvaluadora entidadEvaluadora) {
        this.entidadEvaluadora = entidadEvaluadora;
    }

    public List<SubAmbito> getSubAmbitos() {
        return subAmbitos;
    }

    public void setSubAmbitos(List<SubAmbito> subAmbitos) {
        this.subAmbitos = subAmbitos;
    }

}