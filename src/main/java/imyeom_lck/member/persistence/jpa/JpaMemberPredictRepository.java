package imyeom_lck.member.persistence.jpa;

import imyeom_lck.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberPredictRepository extends JpaRepository<Member, Long> {


}
