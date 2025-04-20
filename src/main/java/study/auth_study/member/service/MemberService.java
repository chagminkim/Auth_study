package study.auth_study.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.auth_study.member.dto.MemberLoginRequest;
import study.auth_study.member.dto.MemberResponseDto;
import study.auth_study.member.dto.MemberUpdateRequestDto;
import study.auth_study.member.entity.Member;
import study.auth_study.member.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    //회원생성
    public MemberResponseDto createMember(String email, String name, String password) {
        if (memberRepository.existsByEmail(email)) {
            System.out.println("존재하는 이메일입니다.");
            return null;
        }
        Member member = new Member(name, email, password);
        Member member1 = memberRepository.save(member);

        MemberResponseDto memberResponseDto = new MemberResponseDto(member1.getId(), member.getName());

        return memberResponseDto;
    }

    public boolean login(MemberLoginRequest request) {
        if (!memberRepository.findByEmail(request.getEmail()).isPresent()) {
            System.out.println("사용자가 존재하지않습니다.");
            return false;
        }

        Member member = memberRepository.findByEmail(request.getEmail()).get();

        if (!member.getPassword().equals(request.getPassword())) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
        return true;
    }

    public MemberResponseDto updateMember(MemberUpdateRequestDto request, Long id) {
        if (!memberRepository.existsById(id)) {
            System.out.println("사용자가 존재하지 않습니다.");
            return null;
        }

        Member member = memberRepository.findById(id).get();

        member.update(request.getName(), request.getPassword());

        Member saved = memberRepository.save(member);

        return new MemberResponseDto(member.getId(), member.getName());
    }


    public List<MemberResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();

        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();

        for (Member member : members) {
            memberResponseDtos.add(new MemberResponseDto(member.getId(), member.getName()));
        }

        return memberResponseDtos;
    }

    public MemberResponseDto getMember(Long id) {
        if (!memberRepository.findById(id).isPresent()) {
            System.out.println("사용자가 존재하지않습니다.");
            return null;
        }

        Member member = memberRepository.findById(id).get();

        return new MemberResponseDto(member.getId(), member.getName());
    }

    public void deleteMember(Long id) {
        if (!memberRepository.findById(id).isPresent()) {
            System.out.println("사용자가 존재하지 않습니다.");
            return;
        }
        memberRepository.deleteById(id);
    }
}