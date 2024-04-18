package imyeom_lck.predict.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.predict.domain.dto.PredictDTO;
import imyeom_lck.predict.domain.dto.PredictRequestDTO;
import imyeom_lck.predict.service.impl.PredictServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PredictRestController.class)
public class PredictRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PredictServiceImpl predictService;

    private PredictDTO predictDto1;
    private PredictRequestDTO predictRequestDTO1;

    @BeforeEach
    void setUp(){
        predictDto1 = PredictDTO.builder().homeTeamVote(1L).awayTeamVote(1L).matchDate(LocalDateTime.of(2024, 4, 17, 15, 30)).build();
        predictRequestDTO1 = PredictRequestDTO.builder().memberId(1L).predictId(1L).flag(true).build();
    }

    @DisplayName("투표")
    @Test
    public void vote() throws Exception {
        given(this.predictService.vote(any(PredictRequestDTO.class))).willReturn(predictDto1);

        this.mvc.perform(post("/api/predict/vote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(predictRequestDTO1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.homeTeamVote").value(1))
                .andExpect(jsonPath("$.data.awayTeamVote").value(1))
                .andExpect(jsonPath("$.data.matchDate").value("2024-04-17T15:30:00"));
    }

}
