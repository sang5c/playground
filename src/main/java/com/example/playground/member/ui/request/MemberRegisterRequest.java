package com.example.playground.member.ui.request;

import lombok.Getter;

@Getter
public class MemberRegisterRequest {
    private final String name;

    public MemberRegisterRequest(String name) {
        this.name = name;
    }
}
