package imyeom_lck.memberpredict.persistence.jpa;

import imyeom_lck.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPredictRepository extends JpaRepository<Member, Long> {


}
