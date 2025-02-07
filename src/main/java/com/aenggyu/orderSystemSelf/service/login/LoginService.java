package com.aenggyu.orderSystemSelf.service.login;

import com.aenggyu.orderSystemSelf.domain.member.Member;

import java.util.Optional;

public interface LoginService {

    Optional<Member> login(String loginId, String password);
}
