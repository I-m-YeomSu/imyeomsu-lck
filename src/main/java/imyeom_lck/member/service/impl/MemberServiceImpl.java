package imyeom_lck.member.service.impl;

import imyeom_lck.common.code.ErrorCode;
import imyeom_lck.common.exception.ClientException;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.domain.entity.MemberRole;
import imyeom_lck.member.domain.entity.SignUpRequest;
import imyeom_lck.member.persistence.jpa.JpaMemberPredictRepository;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.member.persistence.jpa.JpaMemberRoleRepository;
import imyeom_lck.member.service.inter.MemberService;
import imyeom_lck.role.domain.entity.Role;
import imyeom_lck.role.persistence.jpa.JpaRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final JpaMemberRepository memberRepository;
    private final JpaMemberPredictRepository memberPredictRepository;
    private final JpaRoleRepository jpaRoleRepository;
    private final JpaMemberRoleRepository jpaMemberRoleRepository;

    public MemberDetailsResponseDTO getMemberDetails(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ClientException(ErrorCode.MEMBER_INVALID_REQUEST, "잘못된 회원 정보 조회 요청입니다."));

        return new MemberDetailsResponseDTO();
    }

    public Long findByLoginId(String loginId) {
        Member member = memberRepository.findById(Long.valueOf(loginId))
                .orElseThrow(() -> new ClientException(ErrorCode.MEMBER_NOT_FOUND, "해당 id를 가진 회원이 없습니다."));

        return member.getMemberId();
    }

    @Override
    public Member signUp(SignUpRequestDTO signUpRequestDTO) {

//        Member member = memberRepository.findById(signUpRequestDTO.getMemberId()).
//                orElseThrow(() -> new ClientException(ErrorCode.MEMBER_INVALID_REQUEST, "잘못된 회원 정보 조회 요청입니다."));

        log.info(" signuprequestdto {}",signUpRequestDTO.getLoginId());

        Member member = Member.builder()
                .loginId(signUpRequestDTO.getLoginId())
                .password(signUpRequestDTO.getPassword())
                .name(signUpRequestDTO.getName())
                .phoneNumber(signUpRequestDTO.getPhoneNumber())
                .build();

        memberRepository.save(member);
        Optional<Role> op = jpaRoleRepository.findById((long)2);
        if (op.isEmpty()) {
            throw new ClientException(ErrorCode.MEMBER_INVALID_REQUEST, "잘못된 회원 정보 조회 요청입니다.");
        }
        Role role = op.get();

        MemberRole memberRole = MemberRole.createMemberRole(member, role);

        jpaMemberRoleRepository.save(memberRole);

        return member;
    }

    @Override
    public Member deleteMember(Long memberId) {
        Member deleteMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new ClientException(ErrorCode.MEMBER_INVALID_REQUEST, "잘못된 회원 정보 조회 요청입니다."));

        deleteMember.deletedMember(deleteMember.getLoginId());

        return deleteMember;
    }
}

