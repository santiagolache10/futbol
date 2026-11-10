package com.futbol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.model.Entrenador;
import com.futbol.repository.EntrenadorRepository;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController extends CrudController<Entrenador> {

    public EntrenadorController(EntrenadorRepository repo) {
        super(repo);
    }
}