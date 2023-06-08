package com.proyectcens.springbootcens.modelo;

public enum RolEnum {
    ROLE_USER("Usuario"),
    ROLE_ADMIN("Administrador"),
    ROLE_GESTOR("Gestor");

    private String descripcion;

    RolEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
