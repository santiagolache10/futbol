package com.futbol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.model.Club;
import com.futbol.repository.ClubRepository;

@RestController
@RequestMapping("/api/clubes")
public class ClubController extends CrudController<Club> {

    public ClubController(ClubRepository repo) {
        super(repo);
    }
}