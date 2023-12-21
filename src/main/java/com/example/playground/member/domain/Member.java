package com.example.playground.member.domain;

import com.example.playground.team.domain.Team;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
@Entity
public class Member { // TODO: BaseEntity

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
        Assert.hasText(name, "name must not be empty");
        this.name = name;
    }

    public static Member create(String name) {
        return new Member(name);
    }

    public void changeTeam(Team team) {
        this.team = team;
    }
}
