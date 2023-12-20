package com.example.playground.team.domain;

import com.example.playground.member.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long leaderId;

    private boolean active;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    protected Team() {
    }

    private Team(String name, Long leaderId) {
        Assert.hasText(name, "name must not be empty");
        Assert.notNull(leaderId, "leaderId must not be null");
        this.name = name;
        this.leaderId = leaderId;
        this.active = true;
    }

    public static Team create(String name, Long leaderId) {
        return new Team(name, leaderId);
    }

    public void addMember(Member member) {
        members.add(member);
        member.changeTeam(this);
    }

    public void deactivate() {
        if (hasMember()) {
            throw new IllegalStateException("팀에 속한 멤버가 존재합니다.");
        }
        this.active = false;
    }

    private boolean hasMember() {
        return !members.isEmpty();
    }
}
