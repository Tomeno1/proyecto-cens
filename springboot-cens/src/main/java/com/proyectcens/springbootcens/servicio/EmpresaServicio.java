package com.proyectcens.springbootcens.servicio;

import java.util.List;
import com.proyectcens.springbootcens.controlador.dto.EmpresaRegistroDTO;
import com.proyectcens.springbootcens.modelo.Empresa;

public interface EmpresaServicio {

    public Empresa guardar(EmpresaRegistroDTO registroDTO);

    public List<Empresa> listarEmpresa();
}
