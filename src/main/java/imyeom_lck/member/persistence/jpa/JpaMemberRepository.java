package imyeom_lck.member.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import imyeom_lck.member.domain.entity.Member;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginId(String loginId);

    Member findByMemberId(Long memberId);
}

