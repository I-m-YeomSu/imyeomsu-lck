package imyeom_lck.league.controller;

import imyeom_lck.common.controller.IndexController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
@WebMvcTest(LeagueController.class)
class LeagueControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("리그 정보를 보여주는 뷰 화면 테스트 - 성공")
    @Test
    void leagueInfoForm() throws Exception {
        this.mockMvc.perform(get("/leagues"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("leagues/league"));

    }
}