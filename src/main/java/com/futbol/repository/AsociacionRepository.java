package com.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbol.model.Asociacion;

public interface AsociacionRepository extends JpaRepository<Asociacion, Long> {
}