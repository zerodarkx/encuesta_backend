package com.jellies.encuesta.repository;

import com.jellies.encuesta.models.Encuesta;
import com.jellies.encuesta.models.ResultadoEncuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EncuestaRepository extends CrudRepository<Encuesta, Long> {

    @Query("SELECT e FROM Encuesta e WHERE e.email = :email")
    Encuesta existeCorreo(String email);

    @Query("SELECT count(e.estilo) AS contador, e.estilo from Encuesta e group by e.estilo")
    ResultadoEncuesta resultado();
}
