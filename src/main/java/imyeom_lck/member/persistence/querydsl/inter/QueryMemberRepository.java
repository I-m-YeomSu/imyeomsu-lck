package imyeom_lck.member.persistence.querydsl.inter;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.pointusage.domain.entity.PointUsage;

import java.util.List;
import java.util.Optional;

public interface QueryMemberRepository {

    List<Member> queryDSLFindAll();
    Optional<Member> queryDSLFindByMemberId(Long memberId);

    List<PointUsage> queryDSLFindAllPUByMemberId(Long id);
}
