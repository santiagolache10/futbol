package com.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbol.model.Competicion;

public interface CompeticionRepository extends JpaRepository<Competicion, Long> {
}