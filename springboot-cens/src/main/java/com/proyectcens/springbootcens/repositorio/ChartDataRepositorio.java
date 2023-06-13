package com.proyectcens.springbootcens.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectcens.springbootcens.modelo.ChartData;

@Repository
public interface ChartDataRepositorio extends JpaRepository<ChartData, Long> {
    @Query("SELECT a.nombre, AVG(n.calificacion) " +
       "FROM Ambito a " +
       "JOIN a.subAmbitos sa " +
       "JOIN sa.notas n " +
       "GROUP BY a.nombre")
List<Object[]> getChartData();
}
