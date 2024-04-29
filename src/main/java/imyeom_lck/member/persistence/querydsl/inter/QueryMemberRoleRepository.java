package imyeom_lck.member.persistence.querydsl.inter;

import imyeom_lck.member.domain.entity.MemberRole;

import java.util.List;

public interface QueryMemberRoleRepository {

	List<MemberRole> findByMemberLoginId(String loginId);
}
