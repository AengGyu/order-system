package com.aenggyu.orderSystemSelf.service.login;

import com.aenggyu.orderSystemSelf.domain.member.Member;
import com.aenggyu.orderSystemSelf.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final MemberService memberService;

    @Override
    public Optional<Member> login(String loginId, String password) {
        return memberService.findMemberByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password));
    }
}
