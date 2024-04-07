package imyeom_lck.member.service;


import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.dummy.DummyMember;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
    private final Long MEMBER_ID = 1L;
    private final String LOGIN_ID = "test";

    @InjectMocks
    private MemberServiceImpl memberService;

    @Mock
    private JpaMemberRepository memberRepository;

    private Member member;
    private MemberUpdateDTO memberUpdateDTO;

    @BeforeEach
    void setUp() {
        member = DummyMember.dummy();

        memberUpdateDTO = new MemberUpdateDTO();

        memberUpdateDTO = MemberUpdateDTO.builder()
                .loginId("updateID!!")
                .password("updatePW!!")
                .phoneNumber("updatePN!!")
                .cheeringTeam("updateCT!!")
                .build();

        //member.updateMember(memberUpdateDTO);
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
        when(memberRepository.findByLoginId("test")).thenReturn(Optional.of(member));

        // when
        MemberDetailsResponseDTO foundMember = memberService.findByLoginId("test"); // 숫자를 문자열로 변환하여 전달

        // then
        assertEquals(LOGIN_ID, foundMember.getLoginId());
    }

    @Test
    void signUp(){
        //given
        when(memberRepository.findById(MEMBER_ID)).thenReturn(Optional.of(member));

        //when
        MemberDetailsResponseDTO delmember = memberService.deleteMember(MEMBER_ID);

        //then
        assertEquals(true, delmember.isDeleted());
        assertEquals("deleted"  + LOGIN_ID , delmember.getLoginId());
    }


    @Test
    void deletemember(){
        //given
        when(memberRepository.findById(MEMBER_ID)).thenReturn(Optional.of(member));

        //when
        MemberDetailsResponseDTO delmember = memberService.deleteMember(MEMBER_ID);

        //then
        assertEquals(true, delmember.isDeleted());
        assertEquals("deleted"  + LOGIN_ID , delmember.getLoginId());
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
