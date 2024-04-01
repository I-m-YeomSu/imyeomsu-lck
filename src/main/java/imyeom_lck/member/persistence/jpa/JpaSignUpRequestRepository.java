package imyeom_lck.member.persistence.jpa;

import imyeom_lck.member.domain.entity.MemberRole;
import imyeom_lck.member.domain.entity.SignUpRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSignUpRequestRepository extends JpaRepository<SignUpRequest, Long> {
}


