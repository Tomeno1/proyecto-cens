package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import com.proyectcens.springbootcens.modelo.Empresa;

public interface EmpresaServicio {

    public Empresa guardar(Empresa registroEmpresa);

    public List<Empresa> obtenerTodosLosEmpresas();

    public Optional<Empresa> actualizarEmpresa(Long id, Empresa empresa);

    public void eliminarEmpresa(Long id);

    public Empresa obtenerEmpresaPorRut(String rut);

    public Empresa obtenerEmpresaPorId(Long id);

    Empresa ObtenerNombreEmpresa(String nombreEmpresa);

   
    
}
