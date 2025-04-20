package study.auth_study.member.controller;

import org.springframework.web.bind.annotation.*;
import study.auth_study.member.dto.MemberLoginRequest;
import study.auth_study.member.dto.MemberRequestDto;
import study.auth_study.member.dto.MemberResponseDto;
import study.auth_study.member.dto.MemberUpdateRequestDto;
import study.auth_study.member.service.MemberService;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/v1/create")
    public MemberResponseDto createMember(@RequestBody MemberRequestDto memberRequestDto) {
        MemberResponseDto memberResponseDto; // null

        memberResponseDto = memberService.createMember(memberRequestDto.getEmail(), memberRequestDto.getName(), memberRequestDto.getPassword());

        return memberResponseDto;
    }

    //로그인
    @PostMapping("/api/v1/login")
    public boolean login(@RequestBody MemberLoginRequest request) {
        return memberService.login(request);
    }

    //회원 정보 수정
    @PutMapping("/api/v1/updateusers/{id}")
    public MemberResponseDto updateMember(@PathVariable("id") Long id, @RequestBody MemberUpdateRequestDto request) {
        return memberService.updateMember(request, id);
    }

    //회원 정보 리스트 조회
    @GetMapping("/api/v1/getusers")
    public List<MemberResponseDto> getMembers() {
        return memberService.getMembers();
    }


    //회원 정보 단건 조회
    @GetMapping("api/v1/getoneuser/{id}")
    public MemberResponseDto getMember(@PathVariable("id") Long id) {
        return memberService.getMember(id);
    }

    //회원 정보 탈퇴
    @DeleteMapping("/api/v1/deluser/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
    }
}



