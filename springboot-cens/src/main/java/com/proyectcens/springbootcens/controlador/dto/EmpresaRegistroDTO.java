package com.proyectcens.springbootcens.controlador.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class EmpresaRegistroDTO {
    private Long id;
    private String rut;
    private String razonSocial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;

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

    public EmpresaRegistroDTO() {
    }

    public EmpresaRegistroDTO(Long id, String rut, String razonSocial, Date fechaIngreso) {
        this.id = id;
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.fechaIngreso = fechaIngreso;
    }

}