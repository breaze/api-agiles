package com.simon.estudiantes_agiles.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class SaludoController {
    @GetMapping("/{nombre}")
    public String saludar(@PathVariable String nombre){
        return "Hola "+nombre;
    }
}
