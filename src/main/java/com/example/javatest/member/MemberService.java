package com.example.javatest.member;

import com.example.javatest.domain.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long memberId);
}
