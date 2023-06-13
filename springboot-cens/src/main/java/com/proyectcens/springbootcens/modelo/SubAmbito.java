package com.proyectcens.springbootcens.modelo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "sub_ambito")
public class SubAmbito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "ambito_id")
    private Ambito ambito;

    @OneToMany(mappedBy = "subAmbito")
    private List<Nota> notas;

    // Constructores

    public SubAmbito() {
    }

    public SubAmbito(Long id, String nombre, String comentario, Ambito ambito, List<Nota> notas) {
        this.id = id;
        this.nombre = nombre;
        this.comentario = comentario;
        this.ambito = ambito;
        this.notas = notas;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

}