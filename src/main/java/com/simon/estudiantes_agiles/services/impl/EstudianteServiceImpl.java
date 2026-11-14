package com.simon.estudiantes_agiles.services.impl;

import com.simon.estudiantes_agiles.entities.Estudiante;
import com.simon.estudiantes_agiles.repositories.IEstudianteRepository;
import com.simon.estudiantes_agiles.services.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements IEstudianteService {
    private final IEstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findById(Integer id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante update(Integer id, Estudiante estudiante) {
        Estudiante estudianteDb = findById(id);
        if (estudianteDb == null) {
            return null;
        }
        estudianteDb.setNombre(estudiante.getNombre());
        estudianteDb.setApellido(estudiante.getApellido());
        estudianteDb.setEdad(estudiante.getEdad());
        estudianteDb.setCursoId(estudiante.getCursoId());
        return estudianteRepository.save(estudianteDb);
    }

    @Override
    public Estudiante patch(Integer id, Estudiante estudiante) {
        Estudiante estudianteDb = findById(id);
        if (estudianteDb == null) {
            return null;
        }
        if (estudiante.getNombre() != null) {
            estudianteDb.setNombre(estudiante.getNombre());
        }
        if (estudiante.getApellido() != null) {
            estudianteDb.setApellido(estudiante.getApellido());
        }
        if (estudiante.getEdad() != null) {
            estudianteDb.setEdad(estudiante.getEdad());
        }
        if (estudiante.getCursoId() != null) {
            estudianteDb.setCursoId(estudiante.getCursoId());
        }
        return estudianteRepository.save(estudianteDb);
    }

    @Override
    public void deleteById(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
