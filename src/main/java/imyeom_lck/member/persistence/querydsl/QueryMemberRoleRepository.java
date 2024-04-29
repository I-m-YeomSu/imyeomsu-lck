package imyeom_lck.member.persistence.querydsl;

import imyeom_lck.member.domain.entity.MemberRole;

public interface QueryMemberRoleRepository {

	MemberRole findByMemberLoginId(String loginId);
}
