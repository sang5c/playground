package com.example.playground.team.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeamRepository extends TeamRepository, JpaRepository<Team, Long> {
}
