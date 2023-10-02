package com.jellies.encuesta.services;

import com.jellies.encuesta.models.Encuesta;
import com.jellies.encuesta.models.Response;
import com.jellies.encuesta.models.ResultadoEncuesta;
import com.jellies.encuesta.repository.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Qualifier("encuestasServices")
public class EncuestaServicesImp implements EncuestasServices {

    @Autowired
    private EncuestaRepository encuestaRepository;

    @Override
    public List<Encuesta> obtenerEncuestas(){

        return (List<Encuesta>) encuestaRepository.findAll();
    }

    @Override
    public Response saveEncuesta(Encuesta encuesta){
        try {
            Date fecha_creacion = new Date();
            encuesta.setCreate_at(fecha_creacion);
            Response response = new Response();
            if(!this.existeEmail(encuesta.getEmail())){

                response.setEstado(false);
                response.setMensaje("Tu correo esta en uso");
                response.setOpc(2);
                return response;
            }
            encuestaRepository.save(encuesta);
            response.setEstado(true);
            response.setMensaje("Tu correo acaba de votar");
            return response;
        }catch (Exception e){
            System.out.println(e);
            Response response = new Response();
            response.setEstado(false);
            response.setOpc(3);
            response.setMensaje("error al votar");
            return response;
        }
    }
    @Override
    public boolean existeEmail(String email){
        try {
            Encuesta encuesta = encuestaRepository.existeCorreo(email);
            return (encuesta == null) ? true : false;

        }catch (Exception e){
            return false;
//            throw new Exception("falle en buscar");
        }
    }

    @Override
    public Map<String, Long> resultadoEncuesta(){
        List<Encuesta> resultado = (List<Encuesta>) encuestaRepository.findAll();
        Map<String, Long> contador = resultado
                    .stream()
                    .collect(Collectors.groupingBy(Encuesta::getEstilo, Collectors.counting()));
        return contador;
    }

}
