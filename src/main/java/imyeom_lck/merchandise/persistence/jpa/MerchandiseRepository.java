package imyeom_lck.merchandise.persistence.jpa;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.merchandise.domain.entity.Merchandise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchandiseRepository extends JpaRepository<Merchandise, Long> {


}
