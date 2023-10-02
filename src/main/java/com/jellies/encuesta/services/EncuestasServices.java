package com.jellies.encuesta.services;

import com.jellies.encuesta.models.Encuesta;
import com.jellies.encuesta.models.Response;
import com.jellies.encuesta.models.ResultadoEncuesta;

import java.util.List;
import java.util.Map;

public interface EncuestasServices {

    public List<Encuesta> obtenerEncuestas();
    public Response saveEncuesta(Encuesta encuesta);
    boolean existeEmail(String email);
    public Map<String, Long> resultadoEncuesta();
}
