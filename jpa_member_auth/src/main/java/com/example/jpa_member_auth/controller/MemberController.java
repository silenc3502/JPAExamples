package com.example.jpa_member_auth.controller;

import com.example.jpa_member_auth.entity.Member;
import com.example.jpa_member_auth.entity.MemberAuth;
import com.example.jpa_member_auth.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository repository;

    @GetMapping("/register")
    public String getMemberRegister (Member member, Model model) {
        return "/member/register";
    }

    @PostMapping("/register")
    public String register(Member member, Model model) throws Exception {
        Member memberEntity = new Member();

        memberEntity.setUserId(member.getUserId());
        memberEntity.setPassword(member.getPassword());

        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_MEMBER");

        memberEntity.addAuth(memberAuth);

        repository.save(memberEntity);

        // member.setMemberNo(memberEntity.getMemberNo());

        model.addAttribute("msg", "등록이 성공적으로 완료되었습니다!");

        return "member/success";
    }
}
