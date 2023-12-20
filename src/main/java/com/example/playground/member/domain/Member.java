package com.example.playground.member.domain;

import com.example.playground.team.domain.Team;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    protected Member() {
    }

    private Member(String name) {
        this.name = name;
    }

    public static Member create(String name) {
        return new Member(name);
    }

    public void changeTeam(Team team) {
        this.team = team;
    }
}
