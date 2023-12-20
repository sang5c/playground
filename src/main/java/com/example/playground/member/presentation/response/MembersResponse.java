package com.example.playground.member.presentation.response;

import com.example.playground.member.domain.Member;
import lombok.Getter;

import java.util.List;

@Getter
public class MembersResponse {
    private final List<MemberResponse> members;

    private MembersResponse(List<MemberResponse> members) {
        this.members = members;
    }

    public static MembersResponse from(List<Member> members) {
        List<MemberResponse> memberResponses = members.stream()
                .map(MemberResponse::from)
                .toList();
        return new MembersResponse(memberResponses);
    }
}
