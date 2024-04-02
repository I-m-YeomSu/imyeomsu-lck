package imyeom_lck.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestMemberController.class)
public class RestMemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MemberServiceImpl memberService;

    @DisplayName("회원Id로 회원 정보 조회 - 회원이 존재하는 경우")
    @Test
    public void testMemberDetails() throws Exception {
        MemberDetailsResponseDTO dummyMemberDetails = new MemberDetailsResponseDTO("mem1", "123456789", "password1", "TeamA", true, 100);
        given(this.memberService.getMemberDetails(anyLong()))
                .willReturn(dummyMemberDetails);

        this.mvc.perform(get("/members/details/{memberId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberName").value("mem1"))
                .andExpect(jsonPath("$.data.memberPhone").value("123456789"))
                .andExpect(jsonPath("$.data.memberPassword").value("password1"))
                .andExpect(jsonPath("$.data.cheeringTeam").value("TeamA"))
                .andExpect(jsonPath("$.data.memberPoint").value(100));
    }

    @DisplayName("로그인Id로 회원Id 찾기 - 회원이 존재하는 경우")
    @Test
    public void testGetMemberId() throws Exception {
        String existingLoginId = "loginId1";
        Long expectedMemberId = 1L;

        given(memberService.findByLoginId(existingLoginId)).willReturn(expectedMemberId);

        mvc.perform(get("/members/{loginId}", existingLoginId)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().string(String.valueOf(expectedMemberId)));

    }

    @DisplayName("회원가입 - 성공")
    @Test
    public void signUpTestSuc() throws Exception {

        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .name("name1")
                .loginId("memberId1")
                .password("password1")
                .phoneNumber("01033333333")
                .build();

        Member dummyMember = Member.builder()
                .name("name1")
                .loginId("memberId1")
                .password("password1")
                .phoneNumber("01033333333")
                .build();

        given(this.memberService.signUp(any(SignUpRequestDTO.class))).willReturn(dummyMember);

        this.mvc.perform(post("/members/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(signUpRequestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("name1"))
                .andExpect(jsonPath("$.loginId").value("memberId1"))
                .andExpect(jsonPath("$.password").value("password1"))
                .andExpect(jsonPath("$.phoneNumber").value("01033333333"));

    }

    @DisplayName("회원가입 - 실패")
    @Test
    public void signUpTestFail() throws Exception {

        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .name("name1")
                .loginId("memberId1")
                .password("password1")
                .phoneNumber("01033333333")
                .build();

        Member dummyMember = Member.builder()
                .name("name1")
                .loginId("memberId1")
                .password("password1")
                .phoneNumber("01033333333")
                .build();

        given(this.memberService.signUp(any(SignUpRequestDTO.class))).willReturn(dummyMember);

        this.mvc.perform(post("/members/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(signUpRequestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("name1"))
                .andExpect(jsonPath("$.loginId").value("memberId1"))
                .andExpect(jsonPath("$.password").value("password1"))
                .andExpect(jsonPath("$.phoneNumber").value("010"));

    }

    @DisplayName("삭제 - 성공")
    @Test
    public void deleteMemberSuc() throws Exception {

        Long deletedMemberId = 1L;

        Member dummyMember = Member.builder()
                .name("name1")
                .loginId("memberId1")
                .password("password1")
                .phoneNumber("01033333333")
                .isDeleted(true)
                .build();


        given(this.memberService.deleteMember(anyLong())).willReturn(dummyMember);
        this.mvc.perform(post("/members/delete")
                .param("memberId", deletedMemberId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("name1"))
                .andExpect(jsonPath("$.loginId").value("memberId1"))
                .andExpect(jsonPath("$.password").value("password1"))
                .andExpect(jsonPath("$.phoneNumber").value("01033333333"))
                .andExpect(jsonPath("$.deleted").value(true));

    }

    @DisplayName("삭제 - 실패")
    @Test
    public void deleteMemberFail() throws Exception {

        Long deletedMemberId = 1L;

        Member dummyMember = Member.builder()
                .name("name1")
                .loginId("memberId1")
                .password("password1")
                .phoneNumber("01033333333")
                .isDeleted(true)
                .build();


        given(this.memberService.deleteMember(anyLong())).willReturn(dummyMember);
        this.mvc.perform(post("/members/delete")
                        .param("memberId", deletedMemberId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("name1"))
                .andExpect(jsonPath("$.loginId").value("memberId1"))
                .andExpect(jsonPath("$.password").value("password1"))
                .andExpect(jsonPath("$.phoneNumber").value("01033333333"))
                .andExpect(jsonPath("$.deleted").value(false));

    }

    @DisplayName("회원수정 - 성공")
    @Test
    public void updateSuc() throws Exception {

        Long updateMemberId = 1L;

        MemberUpdateDTO memberUpdateDTO = MemberUpdateDTO.builder()
                .name("name1")
                .loginId("memberId1")
                .password("password1")
                .phoneNumber("01033333333")
                .build();

        Member dummyMember = Member.builder()
                .name("update!!!")
                .loginId("update!!!")
                .password("update!!!")
                .phoneNumber("update!!!")
                .build();

        given(this.memberService.updateMember(anyLong(), any(MemberUpdateDTO.class))).willReturn(dummyMember);


        this.mvc.perform(post("/members/update")
                        .param("id", updateMemberId.toString())
                        .param("memberUpdateDTO", String.valueOf(memberUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("update!!!"))
                .andExpect(jsonPath("$.loginId").value("update!!!"))
                .andExpect(jsonPath("$.password").value("update!!!"))
                .andExpect(jsonPath("$.phoneNumber").value("update!!!"));


    }

}
