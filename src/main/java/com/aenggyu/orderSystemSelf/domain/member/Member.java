package com.aenggyu.orderSystemSelf.domain.member;

import com.aenggyu.orderSystemSelf.domain.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private Long id;
    private String loginId;
    private String password;
    private String name;
    private Grade grade;

    public Member(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }
}
