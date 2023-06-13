package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.modelo.Ambito;

import com.proyectcens.springbootcens.repositorio.AmbitoRepositorio;

@Service
public class AmbitoServiciolmpl implements AmbitoServicio {

    @Autowired
    private AmbitoRepositorio ambitoRepositorio;

    public AmbitoServiciolmpl(AmbitoRepositorio ambitoRepositorio) {
        this.ambitoRepositorio = ambitoRepositorio;
    }

    @Override
    public List<Ambito> obtenerTodosLosAmbitos() {
        return ambitoRepositorio.findAll();
    }

    @Override
    public <S extends Ambito> S crearAmbito(S ambito) {
        return ambitoRepositorio.save(ambito);
    }

    @Override
    public Optional<Ambito> actualizarAmbito (Long id) {
        return ambitoRepositorio.findById(id);
    }

    @Override
    public void eliminarAmbito(Long id) {
        ambitoRepositorio.deleteById(id);

    }

    @Override
    public Ambito obtenerAmbitoPorId(Long id) {
        Optional<Ambito> optionalAmbito = ambitoRepositorio.findById(id);
        return optionalAmbito.orElse(null);
    }

    @Override
    public int guardarAmbito(Ambito ambito) {
        int res = 0; // resultado
        Ambito a = ambitoRepositorio.save(ambito); // ambito
        if (!a.equals(null)) {
            res = 1;
        }
        return res;
    }

}
