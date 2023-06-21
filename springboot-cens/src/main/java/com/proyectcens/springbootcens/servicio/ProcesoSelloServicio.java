package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.ProcesoSello;

public interface ProcesoSelloServicio {

    public int guardar(ProcesoSello procesoSello, Long empresaId, Long selloId);

    public List<ProcesoSello> obtenerTodosLosProcesoSello();

    public <S extends ProcesoSello> S crearProcesoSello(S procesoSello);

    public Optional<ProcesoSello> actualizarProcesoSello(Long id);

    public void eliminarProcesoSello(Long id);

    public Empresa obtenerIdEmpresa(long idEmpresa);

}
