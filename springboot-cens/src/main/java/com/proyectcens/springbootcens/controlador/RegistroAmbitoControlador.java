package com.proyectcens.springbootcens.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            String entidadEvaluadora = (String) row[0];
            String ambito = (String) row[1];
            Double promedio = (Double) row[2];
            ResultadoDTO resultadoDTO = new ResultadoDTO(entidadEvaluadora, ambito, promedio);
            resultados.add(resultadoDTO);
        }

        return resultados;
    }

    @GetMapping("/api/porcentaje")
    @ResponseBody
    public ResponseEntity<String> obtenerPorcentajeCumplimientoPorAmbito() throws JsonProcessingException {
        List<Object[]> resultado = ambitoServicio.porcentajeCumplimientoPorAmbito();

        List<Map<String, Object>> data = new ArrayList<>();
        long totalPorcentaje = 0; // Variable para almacenar la suma total de los porcentajes

        for (Object[] row : resultado) {
            String entidadEvaluadora = (String) row[0];
            String ambito = (String) row[1];
            Long porcentaje = (Long) row[2];

            Map<String, Object> entry = new HashMap<>();
            entry.put("entidadEvaluadora", entidadEvaluadora);
            entry.put("ambito", ambito);
            entry.put("porcentaje", porcentaje);
            data.add(entry);

            totalPorcentaje += porcentaje; // Sumar el porcentaje actual al total
        }

        double promedio = totalPorcentaje / (double) resultado.size(); // Calcular el promedio

        Map<String, Object> promedioEntry = new HashMap<>();
        promedioEntry.put("promedioTotal", promedio);
        data.add(promedioEntry);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(data);

        return ResponseEntity.ok(json);
    }

}

// @GetMapping("/listarAmbitos")
// public String obtenerAmbitos(Model model) {
// List<Ambito> ambitos = ambitoServicio.obtenerTodosLosAmbitos();
// model.addAttribute("ambitos", ambitos);
// return "ambito";
// }

// @GetMapping("/crearAmbito")
// public String agregarAmbito(Model model) {
// model.addAttribute("ambito", new Ambito());
// return "formularioAmbito";
// }

// @PostMapping("/guardarAmbitos")
// public String guardarAmbito(@Validated Ambito ambito, Model model) {
// ambitoServicio.guardarAmbito(ambito);
// return "redirect:/listarAmbitos";
// }

// @GetMapping("/actualizarAmbito/{id}")
// public String editarAmbito(@PathVariable Long id, Model model) {
// Optional<Ambito> ambito = ambitoServicio.actualizarAmbito(id);
// model.addAttribute("ambito", ambito);
// return "formularioAmbito";
// }

// @GetMapping("/eliminarAmbito/{id}")
// public String eliminarAmbito(@PathVariable Long id, Model model) {
// ambitoServicio.eliminarAmbito(id);
// return "redirect:/listarAmbitos";
// }
