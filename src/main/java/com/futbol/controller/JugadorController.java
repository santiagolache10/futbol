package com.futbol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.model.Jugador;
import com.futbol.repository.JugadorRepository;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController extends CrudController<Jugador> {

    public JugadorController(JugadorRepository repo) {
        super(repo);
    }
}