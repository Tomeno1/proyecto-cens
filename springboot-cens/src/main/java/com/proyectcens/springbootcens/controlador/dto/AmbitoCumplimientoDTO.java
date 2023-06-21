package com.proyectcens.springbootcens.controlador.dto;

public class AmbitoCumplimientoDTO {
    private String ambito;
    private double cumplimiento;

    public AmbitoCumplimientoDTO(String ambito, double cumplimiento) {
        this.ambito = ambito;
        this.cumplimiento = cumplimiento;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public double getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(double cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    // Getters y Setters
    
}
