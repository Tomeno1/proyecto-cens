package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;

@Service
public class EmpresaServicioImpl implements EmpresaServicio {

    private EmpresaRepositorio empresaRepositorio;

    public EmpresaServicioImpl(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }

    @Override
    public Empresa guardar(Empresa registroEmpresa) {
        Empresa empresa = new Empresa(registroEmpresa.getRut(),
                registroEmpresa.getRazonSocial(), registroEmpresa.getFechaIngreso(), null);

        return empresaRepositorio.save(empresa);
    }

    @Override
    public List<Empresa> obtenerTodosLosEmpresas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosLosEmpresas'");
    }

    @Override
    public void eliminarEmpresa(Long id) {
        empresaRepositorio.deleteById(id);
    }

    @Override
    public Empresa obtenerEmpresaPorRut(String rut) {
        Optional<Empresa> optionalEmpresa = empresaRepositorio.findByRut(rut);
        return optionalEmpresa.orElse(null);
    }

    @Override
    public Empresa crearEmpresa(Empresa empresa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearEmpresa'");
    }

    @Override
    public Optional<Empresa> actualizarEmpresa(Long id, Empresa empresa) {
        return empresaRepositorio.findById(id);
    }

}
