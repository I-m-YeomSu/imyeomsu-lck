package imyeom_lck.member.service.impl;

import imyeom_lck.common.code.ErrorCode;
import imyeom_lck.common.exception.ClientException;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.persistence.jpa.JpaMemberPredictRepository;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import imyeom_lck.member.domain.entity.Member;

import imyeom_lck.member.service.inter.MemberService;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final JpaMemberRepository memberRepository;
    private final JpaMemberPredictRepository memberPredictRepository;

    public MemberDetailsResponseDTO getMemberDetails(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ClientException(ErrorCode.MEMBER_NOT_FOUND, "해당 id를 가진 Member가 없습니다."));

        return new MemberDetailsResponseDTO();
    }

}
