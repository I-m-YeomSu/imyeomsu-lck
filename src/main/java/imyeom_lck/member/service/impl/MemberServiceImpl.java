package imyeom_lck.member.service.impl;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.dto.SignUpMemberResponse;
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
import imyeomsu.lck.common_utils.code.ErrorCode;
import imyeomsu.lck.common_utils.exception.ClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final JpaMemberRepository memberRepository;
    private final JpaRoleRepository jpaRoleRepository;
    private final JpaMemberRoleRepository jpaMemberRoleRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public MemberDetailsResponseDTO getMemberDetails(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ClientException(ErrorCode.MEMBER_INVALID_REQUEST, "잘못된 회원 정보 조회 요청입니다."));

        return MemberDetailsResponseDTO.fromEntity(member);
    }

    public MemberDetailsResponseDTO findByLoginId(String loginId) {
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new ClientException(ErrorCode.MEMBER_NOT_FOUND, "해당 id를 가진 회원이 없습니다."));

        return MemberDetailsResponseDTO.fromEntity(member);
    }

    @Transactional
    @Override
    public SignUpMemberResponse signUp(SignUpRequestDTO signUpRequestDTO) {

        Member member = Member.builder()
                .loginId(signUpRequestDTO.getLoginId())
                .password(encoder.encode(signUpRequestDTO.getPassword())) // pwd encoding
                .name(signUpRequestDTO.getName())
                .phoneNumber(signUpRequestDTO.getPhoneNumber())
                .build();

        memberRepository.save(member);

        Role role = jpaRoleRepository.findById(2L).orElseThrow(()->{
            throw new ClientException(ErrorCode.ROLE_NOT_FOUND, "역할에 대한 정보가 없습니다.");
        });

        MemberRole memberRole = MemberRole.createMemberRole(member, role);

        jpaMemberRoleRepository.save(memberRole);

        return SignUpMemberResponse.fromEntity(member, role);
    }

    @Transactional
    @Override
    public MemberDetailsResponseDTO deleteMember(Long memberId) {
        Member deleteMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new ClientException(ErrorCode.MEMBER_INVALID_REQUEST, "잘못된 회원 정보 조회 요청입니다."));

        deleteMember.deletedMember(deleteMember.getLoginId());

        return MemberDetailsResponseDTO.fromEntity(deleteMember);
    }

    @Transactional
    @Override
    public MemberDetailsResponseDTO updateMember(Long memberId, MemberUpdateDTO memberUpdateDTO){
        Member updateMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new ClientException(ErrorCode.MEMBER_INVALID_REQUEST, "잘못된 회원 정보 조회 요청입니다."));

        updateMember.updateMember(memberUpdateDTO);

        return MemberDetailsResponseDTO.fromEntity(updateMember);
    }
}

