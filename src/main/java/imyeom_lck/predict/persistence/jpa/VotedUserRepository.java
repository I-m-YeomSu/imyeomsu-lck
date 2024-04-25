package imyeom_lck.predict.persistence.jpa;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.predict.domain.entity.VotedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VotedUserRepository extends JpaRepository<VotedUser, Long> {
    List<VotedUser> findByMemberId(Long memberId);
}
