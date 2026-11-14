package com.simon.estudiantes_agiles.controllers;

import com.simon.estudiantes_agiles.entities.Curso;
import com.simon.estudiantes_agiles.services.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService cursoService;



    @GetMapping
    public List<Curso> findAll() {
        return cursoService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Curso curso = cursoService.findById(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso curso) {
        Curso cursoActualizado = cursoService.update(id, curso);
        if (cursoActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursoActualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (cursoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
