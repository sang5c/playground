package com.example.playground.member.application;

import com.example.playground.member.domain.Member;
import com.example.playground.member.domain.MemberRepository;
import com.example.playground.member.ui.response.MemberResponse;
import com.example.playground.member.ui.response.MembersResponse;
import com.example.playground.member.domain.JpaMemberRepository;
import com.example.playground.member.ui.request.MemberRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResponse showMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        return MemberResponse.from(member);
    }

    @Transactional(readOnly = true)
    public MembersResponse showAllMembers() {
        List<Member> members = memberRepository.findAll();
        return MembersResponse.from(members);
    }

    @Transactional
    public MemberResponse registerMember(MemberRegisterRequest request) {
        Member member = Member.create(request.getName());
        Member savedMember = memberRepository.save(member);
        return MemberResponse.from(savedMember);
    }

    @Transactional
    public void deleteMember(Long id) {
        // TODO
    }
}
