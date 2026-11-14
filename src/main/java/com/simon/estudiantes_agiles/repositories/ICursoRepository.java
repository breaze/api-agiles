package com.simon.estudiantes_agiles.repositories;

import com.simon.estudiantes_agiles.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}
