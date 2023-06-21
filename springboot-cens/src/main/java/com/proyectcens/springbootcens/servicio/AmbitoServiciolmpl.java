package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectcens.springbootcens.modelo.Ambito;

import com.proyectcens.springbootcens.repositorio.AmbitoRepositorio;

@Service
public class AmbitoServiciolmpl implements AmbitoServicio {

    @Autowired
    private AmbitoRepositorio ambitoRepositorio;
    @Autowired
    private EntityManager entityManager;

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
    public Optional<Ambito> actualizarAmbito(Long id) {
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

    @Override
    public List<Object[]> promedioPorAmbito() {
        String sql = "SELECT e.nombre AS entidadEvaluadora, a.nombre AS ambito, AVG(n.calificacion) AS promedio "
                + "FROM EntidadEvaluadora e "
                + "JOIN e.ambitos a "
                + "JOIN a.subAmbitos sa "
                + "JOIN sa.notas n "
                + "GROUP BY e.nombre, a.nombre";
        return entityManager.createQuery(sql).getResultList();
    }

    @Override
    public List<Object[]> porcentajeCumplimientoPorAmbito() {
        String sql = "SELECT e.nombre AS entidadEvaluadora, a.nombre AS ambito, " +
                "COUNT(CASE WHEN n.calificacion >= 2 THEN 1 END) * 100 / COUNT(*) AS porcentajeCumplimiento " +
                "FROM EntidadEvaluadora e " +
                "JOIN e.ambitos a " +
                "JOIN a.subAmbitos sa " +
                "JOIN sa.notas n " +
                "GROUP BY e.nombre, a.nombre";

        return entityManager.createQuery(sql).getResultList();
    }

}