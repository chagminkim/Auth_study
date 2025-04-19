package study.auth_study.member.service;

import org.springframework.stereotype.Service;
import study.auth_study.member.dto.MemberCreateRequest;
import study.auth_study.member.dto.MemberInfoResponse;
import study.auth_study.member.dto.MemberLoginRequest;
import study.auth_study.member.dto.MemberUpdateRequest;
import study.auth_study.member.entity.Member;
import study.auth_study.member.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberInfoResponse createMember(MemberCreateRequest request) {
        if (memberRepository.existsByEmail(request.getEmail())) {
            System.out.println("이미 존재하는 이메일입니다.");
            return null;
        }

        Member entity = new Member(
                request.getEmail(),
                request.getPassword(),
                request.getName()
        );

        Member member = memberRepository.save(entity);

        return new MemberInfoResponse(member.getId(), member.getName());
    }

    public boolean login(MemberLoginRequest request) {
        if (!memberRepository.existsByEmail(request.getEmail())) {
            System.out.println("사용자가 존재하지 않습니다.");
            return false;
        }

        Member member = memberRepository.findByEmail(request.getEmail()).get();

        if (!member.getPassword().equals(request.getPassword())) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }

        return true;
    }

    public MemberInfoResponse updateMember(MemberUpdateRequest request, Long id) {
        if (!memberRepository.existsById(id)) {
            System.out.println("사용자가 존재하지 않습니다.");
            return null;
        }

        Member member = memberRepository.findById(id).get();

        member.update(request.getName(), request.getPassword());

        Member saved = memberRepository.save(member);

        return new MemberInfoResponse(saved.getId(), saved.getName());
    }

    public List<MemberInfoResponse> getMembers() {
        List<Member> members = memberRepository.findAll();

        List<MemberInfoResponse> memberInfoResponses = new ArrayList<>();

        for (Member member : members) {
            memberInfoResponses.add(new MemberInfoResponse(member.getId(), member.getName()));
        }

        return memberInfoResponses;
    }

    public MemberInfoResponse getMember(Long id) {
        if (!memberRepository.existsById(id)) {
            System.out.println("사용자가 존재하지 않습니다.");
            return null;
        }

        Member member = memberRepository.findById(id).get();

        return new MemberInfoResponse(member.getId(), member.getName());
    }

    public void deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            System.out.println("사용자가 존재하지 않습니다.");
            return;
        }

        memberRepository.deleteById(id);
    }
}