package com.example.playground.member.ui;

import com.example.playground.member.application.MemberService;
import com.example.playground.member.domain.Member;
import com.example.playground.member.ui.request.MemberRegisterRequest;
import com.example.playground.member.ui.response.MemberResponse;
import com.example.playground.member.ui.response.MembersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public MembersResponse getMembers() {
        List<Member> members = memberService.showAllMembers();
        return MembersResponse.from(members);
    }

    @GetMapping("/members/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        Member member = memberService.showMember(id);
        return MemberResponse.from(member);
    }

    @PostMapping("/members")
    public MemberResponse registerMember(@RequestBody MemberRegisterRequest request) {
        Member registeredMember = memberService.registerMember(request);
        return MemberResponse.from(registeredMember);
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
