package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;

@Service
public class EmpresaServicioImpl implements EmpresaServicio {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public EmpresaServicioImpl(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }

    @Override
    public Empresa guardar(Empresa registroEmpresa) {
        Empresa empresa = empresaRepositorio.save(new Empresa(registroEmpresa.getRut(),
                registroEmpresa.getRazonSocial(), registroEmpresa.getFechaIngreso()));
        if (empresa.getId() <= 0) {
            throw new IllegalStateException("El id de la empresa no es valido.");
        }
        return empresa;
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
    public Optional<Empresa> actualizarEmpresa(Long id, Empresa empresa) {
        return empresaRepositorio.findById(id);
    }

}
