package study.auth_study.member.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.auth_study.member.dto.RequestDto;
import study.auth_study.member.entity.Member;
import study.auth_study.member.repository.MemberRepository;

@Service

@RequiredArgsConstructor

public class MemberService {

    private MemberRepository memberRepository;
}