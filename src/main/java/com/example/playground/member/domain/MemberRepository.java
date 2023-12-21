package com.example.playground.member.domain;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long id);

    List<Member> findAll();

    Member save(Member member);
}
