package com.example.playground.member.application;

import com.example.playground.member.domain.Member;
import com.example.playground.member.domain.MemberRepository;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeMemberRepository implements MemberRepository {
    private final Map<Long, Member> map = new HashMap<>();
    private final AtomicLong id = new AtomicLong(1);

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<Member> findAll() {
        return map.values().stream()
                .toList();
    }

    @Override
    public Member save(Member member) {
        long memberId = id.getAndIncrement();
        ReflectionTestUtils.setField(member, "id", memberId);
        map.put(memberId, member);
        return member;
    }
}
