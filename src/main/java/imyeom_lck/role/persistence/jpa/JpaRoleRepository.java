package imyeom_lck.role.persistence.jpa;

import imyeom_lck.role.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRoleRepository extends JpaRepository<Role, Long> {


}

