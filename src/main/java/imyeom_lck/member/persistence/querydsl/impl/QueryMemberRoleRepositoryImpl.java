package imyeom_lck.member.persistence.querydsl.impl;

import imyeom_lck.member.domain.entity.QMemberRole;
import imyeom_lck.member.persistence.querydsl.inter.QueryMemberRoleRepository;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import imyeom_lck.member.domain.entity.MemberRole;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueryMemberRoleRepositoryImpl implements QueryMemberRoleRepository {
	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<MemberRole> findByMemberLoginId(String loginId) {
		QMemberRole memberRole = QMemberRole.memberRole;

		return jpaQueryFactory.selectFrom(memberRole)
				.where(memberRole.member.loginId.eq(loginId)).fetch();
	}
}
