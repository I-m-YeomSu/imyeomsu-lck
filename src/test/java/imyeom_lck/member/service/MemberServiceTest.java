package imyeom_lck.member.service;


import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
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
    private static final Long MEMBER_ID = 1L;
    private static final String PASSWORD = "password1";
    private static final String PHONENUMBER = "phonenum1";
    private static final String LOGIN_ID = "loginId1";
    private static final boolean CHECK = false;

    @InjectMocks
    private MemberServiceImpl memberService;

    @Mock
    private JpaMemberRepository memberRepository;

    private Member member;
    private MemberUpdateDTO memberUpdateDTO;

    @BeforeEach
    void setUp() {
        member.setMemberId(MEMBER_ID);
        member.setPassword(PASSWORD);
        member.setPhoneNumber(PHONENUMBER);
        member.setLoginId(LOGIN_ID);

        memberUpdateDTO.setLoginId("updateID!!");
        memberUpdateDTO.setPassword("updatePW!!");
        memberUpdateDTO.setPhoneNumber("updatePN!!");
        memberUpdateDTO.setCheeringTeam("updateCT!!");
    }

    @Test
    void getMemberDetails() {
        // given
        when(memberRepository.findById(MEMBER_ID)).thenReturn(Optional.of(member));

        // when
        MemberDetailsResponseDTO responseDTO = memberService.getMemberDetails(MEMBER_ID);

        // then
        assertNotNull(responseDTO); // 회원 정보가 null이 아닌지 확인
    }

    @Test
    void getMemberId() {
        // given
        when(memberRepository.findByLoginId(LOGIN_ID)).thenReturn(Optional.of(member));

        // when
        Long foundMember = memberService.findByLoginId(LOGIN_ID); // 숫자를 문자열로 변환하여 전달

        // then
        assertEquals(MEMBER_ID, foundMember);
    }

    @Test
    void deletemember(){
        //given
        when(memberRepository.findById(MEMBER_ID)).thenReturn(Optional.of(member));

        //when
        Member delmember = memberService.deleteMember(MEMBER_ID);

        //then
        assertEquals(delmember.isDeleted(), true);
        assertEquals(delmember.getLoginId(), "deleted" + LOGIN_ID);
    }

    @Test
    void updatemember(){
        //given
        when(memberRepository.findById(MEMBER_ID)).thenReturn(Optional.of(member));

        //when
        Member updatemember = memberService.updateMember(MEMBER_ID, memberUpdateDTO);

        //then
        assertEquals(updatemember.getLoginId(),"updateID!!");
        assertEquals(updatemember.getPassword(),"updatePW!!");
        assertEquals(updatemember.getPhoneNumber(),"updatePN!!");
        assertEquals(updatemember.getCheeringTeam(),"updateCT!!");
    }

}
