package com.simon.estudiantes_agiles.services.impl;

import com.simon.estudiantes_agiles.entities.Curso;
import com.simon.estudiantes_agiles.repositories.ICursoRepository;
import com.simon.estudiantes_agiles.services.ICursoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements ICursoService {
    private final ICursoRepository cursoRepository;


    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Integer id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Integer id, Curso curso) {
        Curso cursoDb = findById(id);
        if (cursoDb == null) {
            return null;
        }
        cursoDb.setNombre(curso.getNombre());
        return cursoRepository.save(cursoDb);
    }

    @Override
    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }
}
