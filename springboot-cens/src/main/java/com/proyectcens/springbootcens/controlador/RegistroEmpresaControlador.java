
package com.proyectcens.springbootcens.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectcens.springbootcens.controlador.dto.EmpresaRegistroDTO;
import com.proyectcens.springbootcens.modelo.Empresa;
import com.proyectcens.springbootcens.servicio.EmpresaServicio;

@Controller
@RequestMapping("/registroEmpresas")
public class RegistroEmpresaControlador {

    private EmpresaServicio empresaServicio;

    public RegistroEmpresaControlador(EmpresaServicio empresaServicio) {
        super();
        this.empresaServicio = empresaServicio;
    }

    @ModelAttribute("empresa")
    public EmpresaRegistroDTO retornarNuevoEmpresaRegistroDTO() {
        return new EmpresaRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "formRegistroEmpresa";
    }

    @PostMapping
    public String registrarCuentaDeEmpresa(@ModelAttribute("empresa") EmpresaRegistroDTO registroDTO) {
        empresaServicio.guardar(registroDTO);
        return "redirect:/registroUsuarios?exito";
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
