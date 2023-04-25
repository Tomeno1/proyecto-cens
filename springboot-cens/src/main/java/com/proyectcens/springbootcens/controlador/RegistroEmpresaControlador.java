package com.proyectcens.springbootcens.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectcens.springbootcens.controlador.dto.EmpresaRegistroDTO;
import com.proyectcens.springbootcens.servicio.EmpresaServicio;

@Controller
@RequestMapping("/empresas")
public class RegistroEmpresaControlador {

    private EmpresaServicio empresaServicio;

    public RegistroEmpresaControlador(EmpresaServicio empresaServicio) {
        this.empresaServicio = empresaServicio;
    }

    @GetMapping("/registro")
    public String mostrarFormularioDeRegistro(Model modelo) {
        modelo.addAttribute("empresa", new EmpresaRegistroDTO());
        return "registrarEmpresa";
    }

    @PostMapping("/registro")
    public String registrarEmpresa(@ModelAttribute("empresa") EmpresaRegistroDTO registroDTO) {
        empresaServicio.guardar(registroDTO);
        return "redirect:/registrarEmpresa?exito";
    }
}





    /*
     * @GetMapping("/listado")
     * public String listarEmpresas(Model modelo) {
     * List<com.proyectcens.springbootcens.modelo.Empresa> empresas =
     * empresaServicio.listarEmpresa();
     * modelo.addAttribute("empresas", empresas);
     * return "listado-empresas";
     * }
     */


