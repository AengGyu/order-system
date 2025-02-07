package com.aenggyu.orderSystemSelf.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MemberLoginForm {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;
}
