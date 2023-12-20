package com.example.playground.member.presentation;

import com.example.playground.member.application.MemberService;
import com.example.playground.member.presentation.response.MemberResponse;
import com.example.playground.member.presentation.response.MembersResponse;
import com.example.playground.member.presentation.request.MemberRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public MembersResponse getMembers() {
        return memberService.showAllMembers();
    }

    @GetMapping("/members/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.showMember(id);
    }

    @PostMapping("/members")
    public MemberResponse registerMember(@RequestBody MemberRegisterRequest request) {
        return memberService.registerMember(request);
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
