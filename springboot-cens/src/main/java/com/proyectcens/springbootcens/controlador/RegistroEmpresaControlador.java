package com.proyectcens.springbootcens.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.servicio.EmpresaServicio;

@Controller
@RequestMapping
public class RegistroEmpresaControlador {

    private final EmpresaServicio empresaServicio;

    @Autowired
    public RegistroEmpresaControlador(EmpresaServicio empresaServicio) {
        this.empresaServicio = empresaServicio;
    }

    @GetMapping("/crearEmpresa")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "formRegistroEmpresa";
    }

    @PostMapping("/guardarEmpresa")
    public String registrarCuentaDeEmpresa(@RequestParam("rut") String rut,
            @ModelAttribute("empresa") Empresa empresaRegistro, RedirectAttributes redirectAttributes) {
        try {
            Empresa empresaExistente = empresaServicio.obtenerEmpresaPorRut(rut);

            if (empresaExistente != null) {
                redirectAttributes.addAttribute("warning", "La empresa ya está registrada");
                return "redirect:/crearEmpresa";
            } else {
                empresaRegistro.setFechaIngreso(new Date()); // Asignar la fecha actual

                Empresa empresaGuardada = empresaServicio.guardar(empresaRegistro);

                if (empresaGuardada != null) {
                    redirectAttributes.addAttribute("exito",
                            "La empresa se ha registrado exitosamente a la aplicación");
                    return "redirect:/crearUsuarioEmpresa";
                } else {
                    redirectAttributes.addAttribute("error", "La empresa no se pudo registrar");
                    return "redirect:/crearEmpresa";
                }
            }
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Ocurrió un error al procesar la solicitud");
            return "redirect:/crearEmpresa";
        }
    }

    @GetMapping("/buscarEmpresa")
    public String buscarEmpresaPorRut(@RequestParam(value = "rut", required = false) String rut, Model model) {
        if (rut != null) {
            Empresa empresa = empresaServicio.obtenerEmpresaPorRut(rut);
            List<Empresa> empresas = new ArrayList<>();

            if (empresa != null) {
                empresas.add(empresa);
            }

            model.addAttribute("empresas", empresas);
        }

        return "buscarEmpresa";
    }
}
