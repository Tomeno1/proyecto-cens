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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyectcens.springbootcens.controlador.dto.SelloDTO;
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
    public SelloDTO retornarNuevoSelloDTO() {
        return new SelloDTO();
    }

    @GetMapping("/crearSello")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("sello", new Sello());
        return "formRegistroSello";
    }

    @PostMapping("/guardarSello")
    public String registrarSello(@RequestParam("nombre") String nombre,
            @ModelAttribute("sello") SelloDTO registroSelloDto, RedirectAttributes redirectAttributes) {
        try {
            Sello selloExistente = selloServicio.obtenerSelloPorNombre(nombre);

            if (selloExistente != null) {
                redirectAttributes.addAttribute("warning", "El sello ya está registrado");
                return "redirect:/crearSello";
            } else {
                registroSelloDto.setNombre(nombre);

                Sello selloGuardado = selloServicio.guardarSelloEmpresa(registroSelloDto);

                if (selloGuardado != null) {
                    redirectAttributes.addAttribute("exito", "El sello se ha registrado exitosamente");
                    return "redirect:/crearSello";
                } else {
                    redirectAttributes.addAttribute("error", "El sello no se pudo registrar");
                    return "redirect:/crearSello";
                }
            }
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Ocurrió un error al procesar la solicitud");
            return "redirect:/crearSello";
        }
    }

    @GetMapping("/actualizarSello/{id}")
    public String editarSello(@PathVariable Long id, Model model) {
        Optional<Sello> sello = selloServicio.actualizarSello(id);
        model.addAttribute("sello", sello);
        return "formRegistroSello";
    }

    @GetMapping("/eliminarSello/{id}")
    public String eliminarSello(@PathVariable Long id, Model model) {
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
