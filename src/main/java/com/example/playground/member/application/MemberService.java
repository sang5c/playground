package com.example.playground.member.application;

import com.example.playground.member.domain.Member;
import com.example.playground.member.domain.MemberRepository;
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
    public Member showMember(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Member> showAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional
    public Member registerMember(MemberRegisterRequest request) {
        Member member = Member.create(request.getName());
        return memberRepository.save(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        // TODO
    }
}
