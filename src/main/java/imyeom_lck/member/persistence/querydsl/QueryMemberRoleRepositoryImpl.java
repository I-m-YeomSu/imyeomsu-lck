package imyeom_lck.member.persistence.querydsl;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import imyeom_lck.member.domain.entity.MemberRole;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryMemberRoleRepositoryImpl implements QueryMemberRoleRepository{
	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public MemberRole findByMemberLoginId(String loginId) {


		return null;
	}
}
