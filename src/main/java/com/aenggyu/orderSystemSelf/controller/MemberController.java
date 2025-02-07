package com.aenggyu.orderSystemSelf.controller;

import com.aenggyu.orderSystemSelf.domain.Grade;
import com.aenggyu.orderSystemSelf.domain.member.Member;
import com.aenggyu.orderSystemSelf.domain.member.MemberRegisterForm;
import com.aenggyu.orderSystemSelf.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String registerForm(@ModelAttribute("member") MemberRegisterForm form) {
        return "members/register";
    }

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("member") MemberRegisterForm form,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "members/register";
        }

        if (memberService.findMemberByLoginId(form.getLoginId()).isPresent()) {
            bindingResult.rejectValue("loginId", "duplicateLoginId", "이미 존재하는 아이디입니다.");
            return "members/register";
        }

        Member member = new Member(form.getLoginId(), form.getPassword(), form.getName());
        member.setGrade(Grade.BRONZE);

        Member registeredMember = memberService.register(member);
        redirectAttributes.addAttribute("id", registeredMember.getId());
        redirectAttributes.addAttribute("isNew", true);

        return "redirect:/members/{id}";
    }

    @GetMapping("/{id}")
    public String member(@PathVariable Long id, Model model) {
        Member member = memberService.findMemberById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        model.addAttribute("member", member);

        return "/members/member";
    }

    // 회원 가입 구현 했으니까 로그인 구현하고 HomeController 구현하기
}
