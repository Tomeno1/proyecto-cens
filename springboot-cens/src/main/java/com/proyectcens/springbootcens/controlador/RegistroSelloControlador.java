package com.proyectcens.springbootcens.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.proyectcens.springbootcens.modelo.Sello;
import com.proyectcens.springbootcens.servicio.SelloServicio;

@Controller
public class RegistroSelloControlador {
    @Autowired
    private SelloServicio selloServicio;

    public RegistroSelloControlador(SelloServicio selloServicio) {
        super();
        this.selloServicio = selloServicio;

    }

    @ModelAttribute("sello")
    public Sello retornarNuevoSello() {
        return new Sello();
    }

    @GetMapping("/crearSello")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("sello", new Sello());
        return "formRegistroSello";
    }

    @PostMapping("/guardarSello")
    public String registrarSello(@Validated Sello sello, Model model) {
        selloServicio.guardar(sello);
        return "redirect:/crearSello?exito";
    }

    @GetMapping("/actualizarSello/{id}")
    public String editarSello(@PathVariable("id") Long id, Model model) {
        Optional<Sello> sello = selloServicio.actualizarSello(id);
        model.addAttribute("sello", sello);
        return "formRegistroSello";
    }

    @GetMapping("/eliminarSello/{id}")
    public String eliminarSello(@PathVariable("id") Long id, Model model) {
        selloServicio.eliminarSello(id);
        return "redirect:/listadoDeSellos";
    }

    @GetMapping("/listadoDeSellos")
    public String listarSellos(Model model) {
        List<Sello> listaSellos = selloServicio.obtenerTodosLosSellos();
        model.addAttribute("listaSellos", listaSellos);
        return "listadoDeSellos";
    }

}
