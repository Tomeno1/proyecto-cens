package com.proyectcens.springbootcens.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.controlador.dto.EmpresaRegistroDTO;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;

@Service
public class EmpresaServicioImpl implements EmpresaServicio {

    private EmpresaRepositorio empresaRepositorio;

    public EmpresaServicioImpl(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }

    @Override
    public Empresa guardar(EmpresaRegistroDTO registroDTO) {
        Empresa empresa = new Empresa();
        empresa.setRut(registroDTO.getRut());
        empresa.setRazonSocial(registroDTO.getRazonSocial());
        empresa.setFechaIngreso(registroDTO.getFechaIngreso());

        return empresaRepositorio.save(empresa);
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepositorio.findAll();
    }
}
