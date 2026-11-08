package com.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbol.model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}