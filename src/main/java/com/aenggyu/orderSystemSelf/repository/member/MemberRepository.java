package com.aenggyu.orderSystemSelf.repository.member;

import com.aenggyu.orderSystemSelf.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByLoginId(String loginId);
    List<Member> findAll();
}
