package com.proyectcens.springbootcens.modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proceso_sello")
public class ProcesoSello {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_etapa")
    private String nombreEtapa;

    @Column(name = "fecha_nda")
    private Date fechaNda;

    @Column(name = "f_acceso_herramienta")
    private Date fechaAccesoHerramienta;

    @Column(name = "f_creacion_formulario")
    private Date fechaCreacionFormulario;

    @Column(name = "f_envio_formulario")
    private Date fechaEnvioFormulario;

    @Column(name = "f_demostracion")
    private Date fechaDemostracion;

    @Column(name = "f_entrega_inf_evaluadores")
    private Date fechaEntregaInformeEvaluadores;

    @Column(name = "f_entrega_informe")
    private Date fechaEntregaInforme;

    @Column(name = "f_entrega_evidencia_final")
    private Date fechaEntregaEvidenciaFinal;

    @Column(name = "f_entrega_evidencia_fonasa")
    private Date fechaEntregaEvidenciaFonasa;

    @Column(name = "f_integracion_fonasa")
    private Date fechaIntegracionFonasa;

    @Column(name = "f_otorgamiento")
    private Date fechaOtorgamiento;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_sello", referencedColumnName = "id")
    private Sello sello;

    @OneToMany(mappedBy = "procesoSello", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> notas;

    // Construcores

    public ProcesoSello() {
    }

    public ProcesoSello(Long id, String nombreEtapa, Date fechaNda, Date fechaAccesoHerramienta,
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

    // Getters and Setters

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