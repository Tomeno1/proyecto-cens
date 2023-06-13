package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.modelo.ChartData;
import com.proyectcens.springbootcens.repositorio.ChartDataRepositorio;

@Service

public class ChartDataSerciviolmpl implements ChartDataServicio {
    private final ChartDataRepositorio chartDataRepositorio;

    @Autowired
    public ChartDataSerciviolmpl(ChartDataRepositorio chartDataRepositorio) {
        this.chartDataRepositorio = chartDataRepositorio;
    }

    @Override
    public List<ChartData> getChartData() {
        return chartDataRepositorio.getChartData().stream()
                .map(this::mapToChartData)
                .collect(Collectors.toList());
    }

    private ChartData mapToChartData(Object[] chartDataObject) {
        String category = (String) chartDataObject[0];
        Double value = (Double) chartDataObject[1];
        return new ChartData(category, value);
    }
}
