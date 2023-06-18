package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import com.proyectcens.springbootcens.controlador.dto.SelloDTO;

import com.proyectcens.springbootcens.modelo.Sello;

public interface SelloServicio {

    public Sello guardarSelloEmpresa(SelloDTO selloDTO);

    public List<Sello> obtenerTodosLosSellos();

    public <S extends Sello> S crearSello(S Sello);

    public Optional<Sello> actualizarSello(Long id);

    public void eliminarSello(Long id);

    public Sello obtenerSelloPorId(Long id);

    public Sello obtenerSelloPorNombre(String nombre);


}
