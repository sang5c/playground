package com.example.playground.team.application;

import com.example.playground.team.domain.Team;
import com.example.playground.team.presentation.response.TeamResponse;
import com.example.playground.team.presentation.response.TeamsResponse;
import com.example.playground.team.infra.TeamRepository;
import com.example.playground.team.presentation.request.TeamRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional(readOnly = true)
    public TeamsResponse showAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return TeamsResponse.from(teams);
    }

    @Transactional(readOnly = true)
    public TeamResponse showTeam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow();
        return TeamResponse.from(team);
    }

    @Transactional
    public TeamResponse registerTeam(TeamRegisterRequest request) {
        Team savedTeam = teamRepository.save(request.toEntity());
        return TeamResponse.from(savedTeam);
    }

    @Transactional
    public void deactivateTeam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow();
        team.deactivate();
    }
}
