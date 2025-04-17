package study.auth_study.member.controller;

import org.springframework.web.bind.annotation.*;
import study.auth_study.member.dto.MemberCreateRequest;
import study.auth_study.member.dto.MemberInfoResponse;
import study.auth_study.member.dto.MemberLoginRequest;
import study.auth_study.member.dto.MemberUpdateRequest;
import study.auth_study.member.service.MemberService;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 가입
    @PostMapping("/api/v1/members")
    public MemberInfoResponse createMember(@RequestBody MemberCreateRequest request) {
        return memberService.createMember(request);
    }

    // 로그인
    @PostMapping("/api/v1/login")
    public boolean login(@RequestBody MemberLoginRequest request) {
        return memberService.login(request);
    }

    // 회원 정보 수정
    @PutMapping("/api/v1/members/{id}")
    public MemberInfoResponse updateMember(
            @PathVariable Long id,
            @RequestBody MemberUpdateRequest request) {
        return memberService.updateMember(request, id);
    }

    // 회원 정보 리스트 조회
    @GetMapping("/api/v1/members")
    public List<MemberInfoResponse> getMembers() {
        return memberService.getMembers();
    }

    // 회원 정보 단건 조회
    @GetMapping("/api/v1/members/{id}")
    public MemberInfoResponse getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    // 회원 탈퇴
    @DeleteMapping("/api/v1/members/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}



