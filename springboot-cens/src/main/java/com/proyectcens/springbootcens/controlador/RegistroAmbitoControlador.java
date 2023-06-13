package com.proyectcens.springbootcens.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.proyectcens.springbootcens.modelo.Ambito;
import com.proyectcens.springbootcens.servicio.AmbitoServicio;

@Controller
@RequestMapping
public class RegistroAmbitoControlador {

    @Autowired
    private AmbitoServicio ambitoServicio;

    @GetMapping("/listarAmbitos")
    public String obtenerAmbitos(Model model) {
       List<Ambito> ambitos =  ambitoServicio.obtenerTodosLosAmbitos();
       model.addAttribute("ambitos", ambitos);
        return "ambito";
    }

    @GetMapping("/crearAmbito")
    public String agregarAmbito(Model model){
        model.addAttribute("ambito", new Ambito());
        return "formularioAmbito";
    }

    @PostMapping("/guardarAmbitos")
    public String guardarAmbito(@Validated Ambito ambito, Model model){
        ambitoServicio.guardarAmbito(ambito);
        return "redirect:/listarAmbitos";
    }

    @GetMapping("/actualizarAmbito/{id}")
    public String editarAmbito(@PathVariable Long id, Model model){
        Optional<Ambito>ambito=ambitoServicio.actualizarAmbito(id);
        model.addAttribute("ambito", ambito);
        return "formularioAmbito";
    }

    @GetMapping("/eliminarAmbito/{id}")
    public String eliminarAmbito(@PathVariable Long id, Model model){
        ambitoServicio.eliminarAmbito(id);
        return "redirect:/listarAmbitos";
    }
}
