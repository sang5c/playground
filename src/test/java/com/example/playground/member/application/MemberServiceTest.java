package com.example.playground.member.application;

import com.example.playground.member.domain.Member;
import com.example.playground.member.domain.MemberRepository;
import com.example.playground.member.ui.request.MemberRegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    private MemberService memberService;
    private MemberRepository memberRepository;

    @BeforeEach
    void setup() {
        memberRepository = new FakeMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @DisplayName("회원을 등록한다.")
    @Test
    void registerMember() {
        MemberRegisterRequest request = new MemberRegisterRequest("hello");

        Member registeredMember = memberService.registerMember(request);

        assertThat(registeredMember.getName()).isEqualTo("hello");
    }

    @DisplayName("회원을 조회한다.")
    @Test
    void showMember() {
        String name = "hello";
        Member hello = memberRepository.save(Member.create(name));

        Member member = memberService.showMember(hello.getId());

        assertThat(member.getName()).isEqualTo(name);
    }

    @DisplayName("회원 목록을 조회한다.")
    @Test
    void showAllMembers() {
        Member hello = memberRepository.save(Member.create("hello"));
        Member world = memberRepository.save(Member.create("world"));

        List<Member> allMembers = memberService.showAllMembers();

        assertThat(allMembers).containsExactly(hello, world);
    }

}
