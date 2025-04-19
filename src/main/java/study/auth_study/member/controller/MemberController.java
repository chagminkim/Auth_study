package study.auth_study.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.auth_study.member.dto.MemberCreateRequest;
import study.auth_study.member.dto.MemberLoginRequest;
import study.auth_study.member.dto.MemberUpdateRequest;
import study.auth_study.member.service.MemberService;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 가입
    @PostMapping("/api/v1/members")
    public ResponseEntity<?> createMember(@RequestBody MemberCreateRequest request) {

        return ResponseEntity.ok(memberService.createMember(request));
    }

    // 로그인
    @PostMapping("/api/v1/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginRequest request) {
        return ResponseEntity.ok(memberService.login(request));
    }

    // 회원 정보 수정
    @PutMapping("/api/v1/members/{id}")
    public ResponseEntity<?> updateMember(
            @PathVariable Long id,
            @RequestBody MemberUpdateRequest request) {
        return ResponseEntity.ok(memberService.updateMember(request, id));
    }

    // 회원 정보 리스트 조회
    @GetMapping("/api/v1/members")
    public ResponseEntity<?> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    // 회원 정보 단건 조회
    @GetMapping("/api/v1/members/{id}")
    public ResponseEntity<?> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }

    // 회원 탈퇴
    @DeleteMapping("/api/v1/members/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
}



