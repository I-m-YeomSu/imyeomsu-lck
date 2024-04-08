package imyeom_lck.member.persistence.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.domain.entity.QMember;
import imyeom_lck.pointusage.domain.dto.PointUsageResponseDTO;
import imyeom_lck.pointusage.domain.entity.PointUsage;
import imyeom_lck.pointusage.domain.entity.QPointUsage;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hibernate.query.results.Builders.fetch;

@Repository
@RequiredArgsConstructor
@Slf4j
public class QueryMemberRepositoryImpl implements QueryMemberRepository {

    private final JPAQueryFactory jpaQueryFactory;


    public List<Member> queryDSLFindAll() {

        QMember member = QMember.member;

        return jpaQueryFactory
                .selectFrom(member)
                .fetch();

    }

    @Override
    public Optional<Member> queryDSLFindByMemberId(Long memberId) {

        QMember member = QMember.member;

        return Optional.ofNullable(jpaQueryFactory
                .selectFrom(member)
                .where(member.memberId.eq(memberId)).fetchOne());

    }

    @Override
    public List<PointUsage> queryDSLFindAllPUByMemberId(Long id) {

        QPointUsage pointUsage = QPointUsage.pointUsage;
        return jpaQueryFactory
                .selectFrom(pointUsage)
                .innerJoin(pointUsage.member).fetchJoin()
                .where(pointUsage.member.memberId.eq(id))
                .fetch();

    }



}

