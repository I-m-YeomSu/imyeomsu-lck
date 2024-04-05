package imyeom_lck.member.service.inter;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.pointusage.domain.entity.PointUsage;

import java.util.List;

public interface QueryMemberService {

    List<MemberDetailsResponseDTO> findall();

    MemberDetailsResponseDTO findById(Long id);

    List<PointUsage> queryDSLFindAllPUByMemberId(Long id);
}
