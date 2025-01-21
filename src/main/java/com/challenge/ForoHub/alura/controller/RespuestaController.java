package com.challenge.ForoHub.alura.controller;

import com.challenge.ForoHub.alura.model.Respuesta;
import com.challenge.ForoHub.alura.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> getAllRespuestas() {
        return respuestaService.getAllRespuestas();
    }

    @PostMapping
    public ResponseEntity<Respuesta> createRespuesta(@RequestBody Respuesta respuesta) {
        Respuesta newRespuesta = respuestaService.createRespuesta(respuesta);
        return ResponseEntity.ok(newRespuesta);
    }
}