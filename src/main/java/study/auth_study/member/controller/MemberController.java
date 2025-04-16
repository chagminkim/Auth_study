package study.auth_study.member.controller;

import org.springframework.web.bind.annotation.RestController;
import study.auth_study.member.repository.MemberRepository;

@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

}



