package com.jellies.encuesta.controllers;

import com.jellies.encuesta.models.Encuesta;
import com.jellies.encuesta.models.Response;
import com.jellies.encuesta.models.ResultadoEncuesta;
import com.jellies.encuesta.services.EncuestasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/encuestas")
public class EncuestaController {

    @Autowired
    private EncuestasServices encuestaService;

    @GetMapping("/all")
    public List<Encuesta> getAllEncuestas(){
        return encuestaService.obtenerEncuestas();
    }

    @PostMapping("/save")
    public Response saveEncuesta(@RequestBody Encuesta encuesta){
        return encuestaService.saveEncuesta(encuesta);
    }

    @GetMapping("/resultado")
    public Map<String, Long> getResultado(){
        return encuestaService.resultadoEncuesta();
    }
}
