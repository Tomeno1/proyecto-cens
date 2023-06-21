package com.proyectcens.springbootcens.controlador.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.Nota;
import com.proyectcens.springbootcens.modelo.Sello;

public class ProcesoSelloDTO {

    private Long id;
    private String nombreEtapa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNda;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaAccesoHerramienta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCreacionFormulario;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEnvioFormulario;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDemostracion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntregaInformeEvaluadores;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntregaInforme;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntregaEvidenciaFinal;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntregaEvidenciaFonasa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIntegracionFonasa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaOtorgamiento;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Empresa empresa;
    private Sello sello;
    private List<Nota> notas;

    public ProcesoSelloDTO() {
    }

    public ProcesoSelloDTO(Long id, String nombreEtapa, Date fechaNda, Date fechaAccesoHerramienta,
            Date fechaCreacionFormulario, Date fechaEnvioFormulario, Date fechaDemostracion,
            Date fechaEntregaInformeEvaluadores, Date fechaEntregaInforme, Date fechaEntregaEvidenciaFinal,
            Date fechaEntregaEvidenciaFonasa, Date fechaIntegracionFonasa, Date fechaOtorgamiento, Empresa empresa,
            Sello sello, List<Nota> notas) {
        this.id = id;
        this.nombreEtapa = nombreEtapa;
        this.fechaNda = fechaNda;
        this.fechaAccesoHerramienta = fechaAccesoHerramienta;
        this.fechaCreacionFormulario = fechaCreacionFormulario;
        this.fechaEnvioFormulario = fechaEnvioFormulario;
        this.fechaDemostracion = fechaDemostracion;
        this.fechaEntregaInformeEvaluadores = fechaEntregaInformeEvaluadores;
        this.fechaEntregaInforme = fechaEntregaInforme;
        this.fechaEntregaEvidenciaFinal = fechaEntregaEvidenciaFinal;
        this.fechaEntregaEvidenciaFonasa = fechaEntregaEvidenciaFonasa;
        this.fechaIntegracionFonasa = fechaIntegracionFonasa;
        this.fechaOtorgamiento = fechaOtorgamiento;
        this.empresa = empresa;
        this.sello = sello;
        this.notas = notas;
    }

    public ProcesoSelloDTO(String nombreEtapa, Date fechaNda, Date fechaAccesoHerramienta, Date fechaCreacionFormulario,
            Date fechaEnvioFormulario, Date fechaDemostracion, Date fechaEntregaInformeEvaluadores,
            Date fechaEntregaInforme, Date fechaEntregaEvidenciaFinal, Date fechaEntregaEvidenciaFonasa,
            Date fechaIntegracionFonasa, Date fechaOtorgamiento, Empresa empresa, Sello sello, List<Nota> notas) {
        this.nombreEtapa = nombreEtapa;
        this.fechaNda = fechaNda;
        this.fechaAccesoHerramienta = fechaAccesoHerramienta;
        this.fechaCreacionFormulario = fechaCreacionFormulario;
        this.fechaEnvioFormulario = fechaEnvioFormulario;
        this.fechaDemostracion = fechaDemostracion;
        this.fechaEntregaInformeEvaluadores = fechaEntregaInformeEvaluadores;
        this.fechaEntregaInforme = fechaEntregaInforme;
        this.fechaEntregaEvidenciaFinal = fechaEntregaEvidenciaFinal;
        this.fechaEntregaEvidenciaFonasa = fechaEntregaEvidenciaFonasa;
        this.fechaIntegracionFonasa = fechaIntegracionFonasa;
        this.fechaOtorgamiento = fechaOtorgamiento;
        this.empresa = empresa;
        this.sello = sello;
        this.notas = notas;
    }

    public ProcesoSelloDTO(String nombreEtapa, Date fechaNda, Date fechaAccesoHerramienta, Date fechaCreacionFormulario,
            Date fechaEnvioFormulario, Date fechaDemostracion, Date fechaEntregaInformeEvaluadores,
            Date fechaEntregaInforme, Date fechaEntregaEvidenciaFinal, Date fechaEntregaEvidenciaFonasa,
            Date fechaIntegracionFonasa, Date fechaOtorgamiento, Empresa empresa, Sello sello) {
        this.nombreEtapa = nombreEtapa;
        this.fechaNda = fechaNda;
        this.fechaAccesoHerramienta = fechaAccesoHerramienta;
        this.fechaCreacionFormulario = fechaCreacionFormulario;
        this.fechaEnvioFormulario = fechaEnvioFormulario;
        this.fechaDemostracion = fechaDemostracion;
        this.fechaEntregaInformeEvaluadores = fechaEntregaInformeEvaluadores;
        this.fechaEntregaInforme = fechaEntregaInforme;
        this.fechaEntregaEvidenciaFinal = fechaEntregaEvidenciaFinal;
        this.fechaEntregaEvidenciaFonasa = fechaEntregaEvidenciaFonasa;
        this.fechaIntegracionFonasa = fechaIntegracionFonasa;
        this.fechaOtorgamiento = fechaOtorgamiento;
        this.empresa = empresa;
        this.sello = sello;
    }

    
    public ProcesoSelloDTO(Sello sello) {
        this.sello = sello;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public Date getFechaNda() {
        return fechaNda;
    }

    public void setFechaNda(Date fechaNda) {
        this.fechaNda = fechaNda;
    }

    public Date getFechaAccesoHerramienta() {
        return fechaAccesoHerramienta;
    }

    public void setFechaAccesoHerramienta(Date fechaAccesoHerramienta) {
        this.fechaAccesoHerramienta = fechaAccesoHerramienta;
    }

    public Date getFechaCreacionFormulario() {
        return fechaCreacionFormulario;
    }

    public void setFechaCreacionFormulario(Date fechaCreacionFormulario) {
        this.fechaCreacionFormulario = fechaCreacionFormulario;
    }

    public Date getFechaEnvioFormulario() {
        return fechaEnvioFormulario;
    }

    public void setFechaEnvioFormulario(Date fechaEnvioFormulario) {
        this.fechaEnvioFormulario = fechaEnvioFormulario;
    }

    public Date getFechaDemostracion() {
        return fechaDemostracion;
    }

    public void setFechaDemostracion(Date fechaDemostracion) {
        this.fechaDemostracion = fechaDemostracion;
    }

    public Date getFechaEntregaInformeEvaluadores() {
        return fechaEntregaInformeEvaluadores;
    }

    public void setFechaEntregaInformeEvaluadores(Date fechaEntregaInformeEvaluadores) {
        this.fechaEntregaInformeEvaluadores = fechaEntregaInformeEvaluadores;
    }

    public Date getFechaEntregaInforme() {
        return fechaEntregaInforme;
    }

    public void setFechaEntregaInforme(Date fechaEntregaInforme) {
        this.fechaEntregaInforme = fechaEntregaInforme;
    }

    public Date getFechaEntregaEvidenciaFinal() {
        return fechaEntregaEvidenciaFinal;
    }

    public void setFechaEntregaEvidenciaFinal(Date fechaEntregaEvidenciaFinal) {
        this.fechaEntregaEvidenciaFinal = fechaEntregaEvidenciaFinal;
    }

    public Date getFechaEntregaEvidenciaFonasa() {
        return fechaEntregaEvidenciaFonasa;
    }

    public void setFechaEntregaEvidenciaFonasa(Date fechaEntregaEvidenciaFonasa) {
        this.fechaEntregaEvidenciaFonasa = fechaEntregaEvidenciaFonasa;
    }

    public Date getFechaIntegracionFonasa() {
        return fechaIntegracionFonasa;
    }

    public void setFechaIntegracionFonasa(Date fechaIntegracionFonasa) {
        this.fechaIntegracionFonasa = fechaIntegracionFonasa;
    }

    public Date getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(Date fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Sello getSello() {
        return sello;
    }

    public void setSello(Sello sello) {
        this.sello = sello;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    
}
