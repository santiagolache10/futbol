package com.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbol.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
}