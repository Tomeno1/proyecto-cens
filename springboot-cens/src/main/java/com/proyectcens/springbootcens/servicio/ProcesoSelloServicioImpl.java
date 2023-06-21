package com.proyectcens.springbootcens.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.ProcesoSello;
import com.proyectcens.springbootcens.modelo.Sello;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;
import com.proyectcens.springbootcens.repositorio.ProcesoSelloRepositorio;
import com.proyectcens.springbootcens.repositorio.SelloRepositorio;

@Service
public class ProcesoSelloServicioImpl implements ProcesoSelloServicio {

    @Autowired
    private ProcesoSelloRepositorio procesoSelloRepositorio;
    @Autowired
    private EmpresaRepositorio empresaRepositorio;
    @Autowired
    private SelloRepositorio selloRepositorio;

    public ProcesoSelloServicioImpl(ProcesoSelloRepositorio procesoSelloRepositorio,
            EmpresaRepositorio empresaRepositorio, SelloRepositorio selloRepositorio) {
        this.procesoSelloRepositorio = procesoSelloRepositorio;
        this.empresaRepositorio = empresaRepositorio;
        this.selloRepositorio = selloRepositorio;
    }

    @Override
    public int guardar(ProcesoSello procesoSello, Long empresaId, Long selloId) {
        Empresa empresa = empresaRepositorio.getById(empresaId);
        Sello sello = selloRepositorio.getById(selloId);
        int res = 0;
        ProcesoSello ps = procesoSelloRepositorio.save(procesoSello);
        if (ps != null) {
            ps.setEmpresa(empresa);
            ps.setSello(sello);
            procesoSelloRepositorio.save(ps);
            res = 1;
        }
        return res;
    }

    @Override
    public List<ProcesoSello> obtenerTodosLosProcesoSello() {
        return procesoSelloRepositorio.findAll();
    }

    @Override
    public Optional<ProcesoSello> actualizarProcesoSello(Long id) {
        return procesoSelloRepositorio.findById(id);
    }

    @Override
    public void eliminarProcesoSello(Long id) {
        procesoSelloRepositorio.deleteById(id);
    }

    @Override
    public <S extends ProcesoSello> S crearProcesoSello(S procesoSello) {
        return procesoSelloRepositorio.save(procesoSello);
    }

    @Override
    public Empresa obtenerIdEmpresa(long idEmpresa) {
        return empresaRepositorio.getById(idEmpresa);
    }

}
