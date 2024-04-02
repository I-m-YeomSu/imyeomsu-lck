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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestMemberController.class)
public class RestMemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MemberServiceImpl memberService;

    @DisplayName("회원Id로 회원 정보 조회 - 회원이 존재하는 경우")
    @Test
    public void testMemberDetails() throws Exception {
        MemberDetailsResponseDTO dummyMemberDetails = new MemberDetailsResponseDTO("John Doe", "123456789", "password123", "TeamA", true, 100);
        given(this.memberService.getMemberDetails(anyLong()))
                .willReturn(dummyMemberDetails);

        this.mvc.perform(get("/members/details/{memberId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberName").value("John Doe"))
                .andExpect(jsonPath("$.data.memberPhone").value("123456789"))
                .andExpect(jsonPath("$.data.memberPassword").value("password123"))
                .andExpect(jsonPath("$.data.cheeringTeam").value("TeamA"))
                .andExpect(jsonPath("$.data.isAlert").value(true))
                .andExpect(jsonPath("$.data.memberPoint").value(100));

    }

}
