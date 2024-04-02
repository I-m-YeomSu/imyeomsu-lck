package imyeom_lck.member.controller;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

}
