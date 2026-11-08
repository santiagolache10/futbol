package com.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbol.model.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}