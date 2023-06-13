package com.proyectcens.springbootcens.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.modelo.ChartData;

@Service
public interface ChartDataServicio {
    public List<ChartData> getChartData();


}
