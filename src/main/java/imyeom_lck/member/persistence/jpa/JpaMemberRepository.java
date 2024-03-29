package imyeom_lck.member.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import imyeom_lck.member.domain.entity.Member;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {


}
