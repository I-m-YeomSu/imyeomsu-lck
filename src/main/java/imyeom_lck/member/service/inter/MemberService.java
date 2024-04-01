package imyeom_lck.member.service.inter;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;

public interface MemberService {

	MemberDetailsResponseDTO getMemberDetails(Long memberId);
	Long findByLoginId(String loginId);
}
