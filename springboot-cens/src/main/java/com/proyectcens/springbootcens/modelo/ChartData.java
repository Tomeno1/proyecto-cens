package com.proyectcens.springbootcens.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChartData {

    @Id
    private Long id;
    private String category;
    private Double value;

    // Constructores

    public ChartData(String category, Double value) {
        this.category = category;
        this.value = value;
    }

    public ChartData() {

    }

    // Getters y setters

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
