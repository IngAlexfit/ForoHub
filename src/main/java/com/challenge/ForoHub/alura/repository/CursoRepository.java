package com.challenge.ForoHub.alura.repository;

import com.challenge.ForoHub.alura.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}