package com.simon.estudiantes_agiles.controllers;

import com.simon.estudiantes_agiles.entities.Estudiante;
import com.simon.estudiantes_agiles.services.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final IEstudianteService estudianteService;



    @GetMapping
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> findById(@PathVariable Integer id) {
        Estudiante estudiante = estudianteService.findById(id);
        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiante);
    }

    @PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.save(estudiante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteActualizado = estudianteService.update(id, estudiante);
        if (estudianteActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudianteActualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estudiante> patch(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteActualizado = estudianteService.patch(id, estudiante);
        if (estudianteActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudianteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (estudianteService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        estudianteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
