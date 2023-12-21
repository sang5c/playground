package com.example.playground.team.domain;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {
    List<Team> findAll();

    Optional<Team> findById(Long id);

    Team save(Team team);
}
