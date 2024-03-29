package imyeom_lck.role.persistence.jpa;

import imyeom_lck.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Member, Long> {


}
