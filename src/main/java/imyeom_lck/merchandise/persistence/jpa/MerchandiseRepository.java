package imyeom_lck.merchandise.persistence.jpa;

import imyeom_lck.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchandiseRepository extends JpaRepository<Member, Long> {


}
