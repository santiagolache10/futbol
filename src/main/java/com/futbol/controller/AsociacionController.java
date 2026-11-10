package com.futbol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.model.Asociacion;
import com.futbol.repository.AsociacionRepository;

@RestController
@RequestMapping("/api/asociaciones")
public class AsociacionController extends CrudController<Asociacion> {

    public AsociacionController(AsociacionRepository repo) {
        super(repo);
    }
}