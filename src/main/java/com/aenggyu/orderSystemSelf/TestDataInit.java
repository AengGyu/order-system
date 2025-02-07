package com.aenggyu.orderSystemSelf;

import com.aenggyu.orderSystemSelf.domain.Grade;
import com.aenggyu.orderSystemSelf.domain.member.Member;
import com.aenggyu.orderSystemSelf.repository.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init(){

        Member admin = new Member();
        admin.setLoginId("admin");
        admin.setPassword("admin!");
        admin.setName("admin");
        admin.setGrade(Grade.ADMIN);
        memberRepository.save(admin);

        Member test = new Member();
        test.setLoginId("test");
        test.setPassword("test!");
        test.setName("test");
        test.setGrade(Grade.BRONZE);
        memberRepository.save(test);
    }
}
