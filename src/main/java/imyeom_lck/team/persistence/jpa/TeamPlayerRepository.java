package imyeom_lck.team.persistence.jpa;

import imyeom_lck.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamPlayerRepository extends JpaRepository<Member, Long> {


}
