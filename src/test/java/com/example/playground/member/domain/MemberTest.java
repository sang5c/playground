package com.example.playground.member.domain;

import com.example.playground.team.domain.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class MemberTest {

    @Test
    void create() {
        Member hello = Member.create("hello");

        assertThat(hello.getName()).isEqualTo("hello");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void createWithEmptyName(String name) {
        assertThatThrownBy(() -> Member.create(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void changeTeam() {
        Member member = Member.create("hello");
        Team team = Team.create("team", 1L);

        member.changeTeam(team);

        assertThat(member.getTeam()).isEqualTo(team);
    }

    @Test
    void createEmpty() {
        assertThatCode(Member::new)
                .doesNotThrowAnyException();
    }
}
