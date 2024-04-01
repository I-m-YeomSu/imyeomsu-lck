package imyeom_lck.member.repository;

import imyeom_lck.member.controller.RestMemberController;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static java.nio.file.Paths.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestMemberController.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberServiceTest500 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MemberServiceImpl memberService;

    @Test
    @DisplayName("MockMvc를 통한 Product 가져오기 테스트")
    void getProductTest() throws Exception{

        //given
        given(memberService.deleteMember(1L)).willReturn(new Member(1L,"mem2", "password2", "phonenum2", "loginId2"));

        //when
        mockMvc.perform(
                get("/members/delete"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loginId").exists())
                .andExpect(jsonPath("$.password").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.phoneNumber").exists())
                .andDo(print());
    }

}
