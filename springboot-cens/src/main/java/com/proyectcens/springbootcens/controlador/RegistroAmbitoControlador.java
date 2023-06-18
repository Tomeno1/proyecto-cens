package com.proyectcens.springbootcens.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyectcens.springbootcens.controlador.dto.ResultadoDTO;

import com.proyectcens.springbootcens.servicio.AmbitoServicio;

@Controller
@RequestMapping
public class RegistroAmbitoControlador {

    @Autowired
    private AmbitoServicio ambitoServicio;

 
    @GetMapping("/api/promedio")
    @ResponseBody
    public List<ResultadoDTO> promedioPorAmbito() {
        List<Object[]> lista = ambitoServicio.promedioPorAmbito();
        List<ResultadoDTO> resultados = new ArrayList<>();

        for (Object[] row : lista) {
            String category = (String) row[0];
            Double value = (Double) row[1];
            ResultadoDTO resultadoDTO = new ResultadoDTO(category, value);
            resultados.add(resultadoDTO);
        }

        return resultados;
    }
}

//    @GetMapping("/listarAmbitos")
//     public String obtenerAmbitos(Model model) {
//         List<Ambito> ambitos = ambitoServicio.obtenerTodosLosAmbitos();
//         model.addAttribute("ambitos", ambitos);
//         return "ambito";
//     }

//     @GetMapping("/crearAmbito")
//     public String agregarAmbito(Model model) {
//         model.addAttribute("ambito", new Ambito());
//         return "formularioAmbito";
//     }

//     @PostMapping("/guardarAmbitos")
//     public String guardarAmbito(@Validated Ambito ambito, Model model) {
//         ambitoServicio.guardarAmbito(ambito);
//         return "redirect:/listarAmbitos";
//     }

//     @GetMapping("/actualizarAmbito/{id}")
//     public String editarAmbito(@PathVariable Long id, Model model) {
//         Optional<Ambito> ambito = ambitoServicio.actualizarAmbito(id);
//         model.addAttribute("ambito", ambito);
//         return "formularioAmbito";
//     }

//     @GetMapping("/eliminarAmbito/{id}")
//     public String eliminarAmbito(@PathVariable Long id, Model model) {
//         ambitoServicio.eliminarAmbito(id);
//         return "redirect:/listarAmbitos";
//     }