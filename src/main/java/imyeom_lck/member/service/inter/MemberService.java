package imyeom_lck.member.service.inter;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.domain.entity.SignUpRequest;

public interface MemberService {

	MemberDetailsResponseDTO getMemberDetails(Long memberId);
	Long findByLoginId(String loginId);

	Member signUp(SignUpRequestDTO signUpRequestDTO);

	Member deleteMember(Long memberId);

	MemberUpdateDTO updateMember(Long memberId, MemberUpdateDTO memberUpdateDTO);
}
