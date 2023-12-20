package com.example.playground.team.presentation.request;

import com.example.playground.team.domain.Team;
import lombok.Getter;

@Getter
public class TeamRegisterRequest {
    private final String name;
    private final Long leaderId;

    public TeamRegisterRequest(String name, Long leaderId) {
        this.name = name;
        this.leaderId = leaderId;
    }

    public Team toEntity() {
        return Team.create(name, leaderId);
    }
}
