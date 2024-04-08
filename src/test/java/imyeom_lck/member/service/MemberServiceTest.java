package imyeom_lck.member.service;


import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.dto.SignUpMemberResponse;
import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.domain.entity.MemberRole;
import imyeom_lck.member.dummy.DummyMember;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.member.persistence.jpa.JpaMemberRoleRepository;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import imyeom_lck.role.domain.entity.Role;
import imyeom_lck.role.persistence.jpa.JpaRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberServiceTest {
    private final Long MEMBER_ID = 1L;
    private final String LOGIN_ID = "test";

    @InjectMocks
    private MemberServiceImpl memberService;

    @Mock
    private JpaMemberRepository memberRepository;

    @Mock
    private JpaRoleRepository jpaRoleRepository;
    @Mock
    private JpaMemberRoleRepository jpaMemberRoleRepository;

    private Member member;
    private MemberUpdateDTO memberUpdateDTO;

    private SignUpRequestDTO signUpRequestDTO;
    private MemberRole memberRole;
    private Role role;

    @BeforeEach
    void setUp() {
        member = DummyMember.dummy();
        member = Member.builder()
                .memberId(1L)
                .password("pw")
                .phoneNumber("pn")
                .loginId("lid")
                .build();

        memberUpdateDTO = new MemberUpdateDTO();

        memberUpdateDTO = MemberUpdateDTO.builder()
                .loginId("updateID!!")
                .password("updatePW!!")
                .phoneNumber("updatePN!!")
                .cheeringTeam("updateCT!!")
                .build();

        signUpRequestDTO = SignUpRequestDTO.builder()
                .loginId("lid")
                .password("pw")
                .phoneNumber("pn")
                .build();

        role = Role.builder()
                .name("roleName")
                .build();

        memberRole = MemberRole.createMemberRole(member, role);
    }


    @DisplayName("회원 정보 찾기 - 성공")
    @Test
    void getMemberDetails() {

        // given
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));


        // when
        MemberDetailsResponseDTO responseDTO = memberService.getMemberDetails(1L);


        // then
        assertNotNull(responseDTO.getLoginId()); // 회원 정보가 null이 아닌지 확인

    }

    @DisplayName("회원 로그인 아이디로 회원 정보 찾기 - 성공")
    @Test
    void getMemberId() {
        // given
        when(memberRepository.findByLoginId("lid")).thenReturn(Optional.of(member));

        // when
        MemberDetailsResponseDTO foundMember = memberService.findByLoginId("lid"); // 숫자를 문자열로 변환하여 전달

        // then
        assertEquals("lid", foundMember.getLoginId());
    }

    @Test
    void signUp(){
        //given
        when(memberRepository.save(any())).thenReturn(member); // void 메서드에 대한 Mock 처리
        when(jpaRoleRepository.findById(2L)).thenReturn(Optional.of(role)); // Optional 반환하는 메서드에 대한 Mock 처리
        when(jpaMemberRoleRepository.save(any())).thenReturn(memberRole); // void 메서드에 대한 Mock 처리

        //when
        SignUpMemberResponse newmember = memberService.signUp(signUpRequestDTO);

        //then
        assertEquals("lid", newmember.getLoginId());
        assertEquals("pw", newmember.getMemberPassword());
        assertEquals("roleName", newmember.getRoleName());
    }


    @Test
    void deletemember(){
        //given
        when(memberRepository.findById(member.getMemberId())).thenReturn(Optional.of(member));

        //when
        MemberDetailsResponseDTO delmember = memberService.deleteMember(member.getMemberId());

        //then
        assertEquals(true, delmember.isDeleted());
        assertEquals("deletedlid", delmember.getLoginId());
    }

    @Test
    void updatemember(){
        //given
        when(memberRepository.findById(MEMBER_ID)).thenReturn(Optional.of(member));

        //when
        MemberDetailsResponseDTO updatemember = memberService.updateMember(MEMBER_ID, memberUpdateDTO);

        //then
        assertEquals(updatemember.getLoginId(),"updateID!!");
        assertEquals(updatemember.getMemberPassword(),"updatePW!!");
        assertEquals(updatemember.getMemberPhone(),"updatePN!!");
        assertEquals(updatemember.getCheeringTeam(),"updateCT!!");
    }

}
