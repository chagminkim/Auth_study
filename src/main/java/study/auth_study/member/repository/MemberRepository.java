package study.auth_study.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.auth_study.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(Long id);
}
