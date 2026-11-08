package com.futbol.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbol.model.Club;
import com.futbol.repository.ClubRepository;

@RestController
@RequestMapping("/api/clubes")
public class ClubController {

    private final ClubRepository clubRepo;

    public ClubController(ClubRepository clubRepo) {
        this.clubRepo = clubRepo;
    }

    @GetMapping
    public List<Club> listar() {
        return clubRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> buscar(@PathVariable Long id) {
        return clubRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}