package com.proyectcens.springbootcens.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.servicio.EmpresaServicio;

@Controller
@RequestMapping
public class RegistroEmpresaControlador {

    private final EmpresaServicio empresaServicio;

    public RegistroEmpresaControlador(EmpresaServicio empresaServicio) {
        this.empresaServicio = empresaServicio;
    }

    @ModelAttribute("empresa")
    public Empresa retornarNuevoEmpresaRegistroDTO() {
        return new Empresa();
    }

    @GetMapping("/crearEmpresa")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "formRegistroEmpresa";
    }

    @PostMapping("/guardarEmpresa")
    public String registrarCuentaDeEmpresa(@ModelAttribute("empresa") Empresa empresaRegistro) {
        Empresa empresaGuardada = empresaServicio.guardar(empresaRegistro);
        if (empresaGuardada != null) {
            return "redirect:/crearUsuario?exito";
        } else {
            // Manejar el caso de error al guardar la empresa
            return "redirect:/crearEmpresa?error";
        }
    }

    @GetMapping("/buscarEmpresa")
    public String obtenerEmpresaPorId(@RequestParam("rut") String rut, Model model) {
        Empresa empresa = empresaServicio.obtenerEmpresaPorRut(rut);
        List<Empresa> empresas = new ArrayList<>();

        if (empresa != null) {
            empresas.add(empresa);
        }

        model.addAttribute("empresas", empresas);
        return "empresa";
    }
}
