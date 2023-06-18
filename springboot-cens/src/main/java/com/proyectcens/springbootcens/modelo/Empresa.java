package com.proyectcens.springbootcens.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rut")
    private String rut;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "fecha_ingreso")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    // Constructores

    public Empresa() {
    }

    public Empresa(String rut, String razonSocial, Date fechaIngreso, List<Usuario> usuarios) {
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.fechaIngreso = fechaIngreso;
        this.usuarios = usuarios;
    }

    public Empresa(Long id, String rut, String razonSocial, Date fechaIngreso, List<Usuario> usuarios) {
        this.id = id;
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.fechaIngreso = fechaIngreso;
        this.usuarios = usuarios;
    }

    public Empresa(String rut, String razonSocial, Date fechaIngreso) {
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
