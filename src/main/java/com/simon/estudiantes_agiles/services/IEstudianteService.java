package com.simon.estudiantes_agiles.services;

import com.simon.estudiantes_agiles.entities.Estudiante;

import java.util.List;

public interface IEstudianteService {
    List<Estudiante> findAll();

    Estudiante findById(Integer id);

    Estudiante save(Estudiante estudiante);

    Estudiante update(Integer id, Estudiante estudiante);

    Estudiante patch(Integer id, Estudiante estudiante);

    void deleteById(Integer id);
}
