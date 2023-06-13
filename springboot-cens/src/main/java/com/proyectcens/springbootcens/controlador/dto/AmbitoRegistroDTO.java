package com.proyectcens.springbootcens.controlador.dto;

public class AmbitoRegistroDTO {
    private String nombre;
    private Long selloId;
    private Long entidadEvaluadoraId;

    public AmbitoRegistroDTO() {
    }

    public AmbitoRegistroDTO(String nombre, Long selloId, Long entidadEvaluadoraId) {
        this.nombre = nombre;
        this.selloId = selloId;
        this.entidadEvaluadoraId = entidadEvaluadoraId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getSelloId() {
        return selloId;
    }

    public void setSelloId(Long selloId) {
        this.selloId = selloId;
    }

    public Long getEntidadEvaluadoraId() {
        return entidadEvaluadoraId;
    }

    public void setEntidadEvaluadoraId(Long entidadEvaluadoraId) {
        this.entidadEvaluadoraId = entidadEvaluadoraId;
    }
}
