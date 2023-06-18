package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.controlador.dto.SelloDTO;
import com.proyectcens.springbootcens.modelo.Sello;
import com.proyectcens.springbootcens.repositorio.SelloRepositorio;

@Service
public class SelloServicioImpl implements SelloServicio {

    @Autowired
    private SelloRepositorio selloRepositorio;

    public SelloServicioImpl(SelloRepositorio selloRepositorio) {
        this.selloRepositorio = selloRepositorio;
    }

    @Override
    public Sello guardarSelloEmpresa(SelloDTO selloDTO) {
        Sello sello = selloRepositorio.save(new Sello(selloDTO.getNombre(), selloDTO.getDescripcion()));
        if (sello.getId() <= 0) {
            throw new IllegalStateException("El id del sello no es valido.");
        }
        return sello;
    }

    @Override
    public List<Sello> obtenerTodosLosSellos() {
        return selloRepositorio.findAll();
    }

    @Override
    public <S extends Sello> S crearSello(S Sello) {
        return selloRepositorio.save(Sello);
    }

    @Override
    public Optional<Sello> actualizarSello(Long id) {
        return selloRepositorio.findById(id);
    }

    @Override
    public void eliminarSello(Long id) {
        selloRepositorio.deleteById(id);
    }

    @Override
    public Sello obtenerSelloPorId(Long id) {
        Optional<Sello> optionalSello = selloRepositorio.findById(id);
        return optionalSello.orElse(null);
    }

    @Override
    public Sello obtenerSelloPorNombre(String nombre) {
        Optional<Sello> optionalSello = selloRepositorio.findByNombre(nombre);
        return optionalSello.orElse(null);
    }

}
