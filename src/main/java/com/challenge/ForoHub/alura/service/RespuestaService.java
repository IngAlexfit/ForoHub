package com.challenge.ForoHub.alura.service;

import com.challenge.ForoHub.alura.model.Respuesta;
import com.challenge.ForoHub.alura.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public List<Respuesta> getAllRespuestas() {
        return respuestaRepository.findAll();
    }

    public Respuesta createRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }
}