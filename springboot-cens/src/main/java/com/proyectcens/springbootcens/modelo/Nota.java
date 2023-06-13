package com.proyectcens.springbootcens.modelo;

import javax.persistence.*;

@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "calificacion")
    private Integer calificacion;

    @ManyToOne
    @JoinColumn(name = "sub_ambito_id", referencedColumnName = "id")
    private SubAmbito subAmbito;

    @ManyToOne
    @JoinColumn(name = "proceso_sello_id", referencedColumnName = "id")
    private ProcesoSello procesoSello;

    // Constructores

    public Nota() {
    }

    public Nota(Long id, Integer calificacion, SubAmbito subAmbito, ProcesoSello procesoSello) {
        this.id = id;
        this.calificacion = calificacion;
        this.subAmbito = subAmbito;
        this.procesoSello = procesoSello;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public SubAmbito getSubAmbito() {
        return subAmbito;
    }

    public void setSubAmbito(SubAmbito subAmbito) {
        this.subAmbito = subAmbito;
    }

    public ProcesoSello getProcesoSello() {
        return procesoSello;
    }

    public void setProcesoSello(ProcesoSello procesoSello) {
        this.procesoSello = procesoSello;
    }

}