package imyeom_lck.member.persistence.jpa;

import imyeom_lck.member.domain.entity.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMemberRoleRepository extends JpaRepository<MemberRole, Long> {


}
