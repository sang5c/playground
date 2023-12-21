package com.example.playground.team.ui.response;

import com.example.playground.member.ui.response.MembersResponse;
import com.example.playground.team.domain.Team;
import lombok.Getter;

@Getter
public class TeamResponse {
    private final Long id;
    private final String name;
    private final MembersResponse members;

    private TeamResponse(Long id, String name, MembersResponse members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public static TeamResponse from(Team team) {
        return new TeamResponse(team.getId(), team.getName(), MembersResponse.from(team.getMembers()));
    }
}
