package com.proyectcens.springbootcens.controlador.dto;

public class ResultadoDTO {
    private String entidadEvaluadora;
    private String ambito;
    private Double promedio;

    public ResultadoDTO() {
    }

    public ResultadoDTO(String entidadEvaluadora, String ambito, Double promedio) {
        this.entidadEvaluadora = entidadEvaluadora;
        this.ambito = ambito;
        this.promedio = promedio;
    }

    // Getters y setters

    public String getEntidadEvaluadora() {
        return entidadEvaluadora;
    }

    public void setEntidadEvaluadora(String entidadEvaluadora) {
        this.entidadEvaluadora = entidadEvaluadora;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
}
