package com.futbol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.model.Competicion;
import com.futbol.repository.CompeticionRepository;

@RestController
@RequestMapping("/api/competiciones")
public class CompeticionController extends CrudController<Competicion> {

    public CompeticionController(CompeticionRepository repo) {
        super(repo);
    }
}