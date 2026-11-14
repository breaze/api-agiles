package com.simon.estudiantes_agiles.repositories;

import com.simon.estudiantes_agiles.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
