package com.example.playground.team.ui.response;

import com.example.playground.team.domain.Team;
import lombok.Getter;

import java.util.List;

@Getter
public class TeamsResponse {
    private final List<TeamResponse> teams;

    private TeamsResponse(List<TeamResponse> teamResponses) {
        this.teams = teamResponses;
    }

    public static TeamsResponse from(List<Team> teams) {
        List<TeamResponse> teamResponses = teams.stream()
                .map(TeamResponse::from)
                .toList();
        return new TeamsResponse(teamResponses);
    }
}
