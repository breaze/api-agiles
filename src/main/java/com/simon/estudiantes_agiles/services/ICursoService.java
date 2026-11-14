package com.simon.estudiantes_agiles.services;

import com.simon.estudiantes_agiles.entities.Curso;

import java.util.List;

public interface ICursoService {
    List<Curso> findAll();

    Curso findById(Integer id);

    Curso save(Curso curso);

    Curso update(Integer id, Curso curso);

    void deleteById(Integer id);
}
