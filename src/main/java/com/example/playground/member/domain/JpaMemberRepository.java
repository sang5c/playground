package com.example.playground.member.domain;

import com.example.playground.member.domain.Member;
import com.example.playground.member.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends MemberRepository, JpaRepository<Member, Long> {
}
