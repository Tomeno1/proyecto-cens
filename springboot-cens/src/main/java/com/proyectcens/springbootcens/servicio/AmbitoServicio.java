
package com.proyectcens.springbootcens.servicio;

import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.modelo.Ambito;

import java.util.List;
import java.util.Optional;

@Service
public interface AmbitoServicio {
    public List<Ambito> obtenerTodosLosAmbitos();

    public <S extends Ambito> S crearAmbito(S ambito);

    public Optional<Ambito> actualizarAmbito(Long id);

    public int guardarAmbito(Ambito ambito);

    public void eliminarAmbito(Long id);

    public Ambito obtenerAmbitoPorId(Long id);

    List<Object[]>  promedioPorAmbito();
}
