package com.challenge.ForoHub.alura.service;

import com.challenge.ForoHub.alura.model.Curso;
import com.challenge.ForoHub.alura.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
}