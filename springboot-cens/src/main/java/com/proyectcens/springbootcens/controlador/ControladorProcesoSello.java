package com.proyectcens.springbootcens.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.modelo.ProcesoSello;
import com.proyectcens.springbootcens.modelo.Sello;
import com.proyectcens.springbootcens.repositorio.EmpresaRepositorio;
import com.proyectcens.springbootcens.repositorio.ProcesoSelloRepositorio;
import com.proyectcens.springbootcens.repositorio.SelloRepositorio;
import com.proyectcens.springbootcens.servicio.EmpresaServicio;
import com.proyectcens.springbootcens.servicio.ProcesoSelloServicio;
import com.proyectcens.springbootcens.servicio.SelloServicio;

@Controller
public class ControladorProcesoSello {

    @Autowired
    private ProcesoSelloServicio procesoSelloServicio;
    @Autowired
    private EmpresaServicio empresaServicio;
    @Autowired
    private EmpresaRepositorio empresaRepositorio;
    @Autowired
    private SelloRepositorio selloRepositorio;
    @Autowired
    private SelloServicio selloServicio;
    @Autowired
    private ProcesoSelloRepositorio procesoSelloRepositorio;

    public ControladorProcesoSello(ProcesoSelloServicio procesoSelloServicio, EmpresaServicio empresaServicio,
            EmpresaRepositorio empresaRepositorio, SelloServicio selloServicio, SelloRepositorio selloRepositorio) {
        this.procesoSelloServicio = procesoSelloServicio;
        this.empresaServicio = empresaServicio;
        this.empresaRepositorio = empresaRepositorio;
        this.selloServicio = selloServicio;
        this.selloRepositorio = selloRepositorio;
    }

    @ModelAttribute("procesoSello")
    public ProcesoSello retornarNuevoProcesoSello() {
        return new ProcesoSello();
    }

    @GetMapping("/crearProcesoSello")
    public String mostrarFormularioProcesoSello(@RequestParam("empresaId") Long empresaId, Model model) {
        Empresa empresa = empresaServicio.obtenerEmpresaPorId(empresaId);
        List<Sello> sellos = selloServicio.obtenerTodosLosSellos();
        model.addAttribute("procesoSello", new ProcesoSello());
        model.addAttribute("sellos", sellos);
        model.addAttribute("empresa", empresa);

        // Retornar la vista del formulario de proceso de sello
        return "procesoSello";
    }

    @PostMapping("/guardarProcesoSello")
    public String guardarProcesoSello(@RequestParam("empresaId") Long empresaId,
            @RequestParam("selloId") Long selloId,
            @ModelAttribute("procesoSello") ProcesoSello procesoSello,
            Model model) {
        int res = procesoSelloServicio.guardar(procesoSello, empresaId, selloId);
        if (res == 1) {
            return "redirect:/buscarEmpresa";
        } else {
            // Manejar el caso de error en el guardado del procesoSello
            return "error";
        }
    }

    @GetMapping("/actualizarProcesoSello/{id}")
    public String actualizarProcesoSello(@PathVariable("id") Long id, @RequestParam("empresaId") Long empresaId,
            Model model) {
        Empresa empresa = empresaServicio.obtenerEmpresaPorId(empresaId);
        List<Sello> sellos = selloServicio.obtenerTodosLosSellos();
        Optional<ProcesoSello> procesoSello = procesoSelloRepositorio.findById(id);

        if (procesoSello.isPresent()) {
            model.addAttribute("procesoSello", procesoSello.get());
            model.addAttribute("sellos", sellos);
            model.addAttribute("empresa", empresa);
            // Retornar la vista del formulario de proceso de sello
            return "procesoSello";
        } else {
            System.out.println("El proceso de sello con ID " + id + " no se encontró.");
            // Aquí puedes agregar un mensaje de error en el modelo o redirigir a una página
            // de error
            return "error"; // O cambiarlo a la vista que desees para mostrar el error
        }
    }

    @GetMapping("/eliminarProcesoSello/{id}")
    public String eliminarProcesoSello(@PathVariable Long id, Model model) {
        procesoSelloServicio.eliminarProcesoSello(id);
        return "redirect:/buscarEmpresa";
    }

}

// @GetMapping("/crearProcesoSello")
// public String mostrarFormularioProcesoSello(@RequestParam("empresaId") Long
// empresaId, Model model) {
// Empresa empresa = empresaServicio.obtenerEmpresaPorId(empresaId);
// List<Sello> listaSellos = selloServicio.obtenerTodosLosSellos();
// model.addAttribute("listaSellos", listaSellos);
// model.addAttribute("empresa", empresa);

// // Retornar la vista del formulario de proceso de sello
// return "procesoSello";
// }