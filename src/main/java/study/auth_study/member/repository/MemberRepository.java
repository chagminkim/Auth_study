package study.auth_study.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.auth_study.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Member> id(Long id);

    Long Id(Long id);
}
