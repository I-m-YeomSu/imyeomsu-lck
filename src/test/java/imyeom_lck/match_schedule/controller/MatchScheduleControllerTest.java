package imyeom_lck.match_schedule.controller;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.dummy.DummyMatchSchedule;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.awaitility.Awaitility.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestMatchScheduleController.class)
public class MatchScheduleControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MatchScheduleService matchScheduleService;

    @Test
    public void testGetAllMatches() throws Exception{
        MatchesResponseDTO match1 = new MatchesResponseDTO("2024-04-12", "20:00", "In Progress", "Football Match",
                "2", "1", "Home Team", "home_team_logo.png",
                "Away Team", "away_team_logo.png");

        // 데이터를 하드코딩하여 두 번째 객체 생성
        MatchesResponseDTO match2 = new MatchesResponseDTO("2024-04-13", "15:30", "Scheduled", "Basketball Game",
                "0", "0", "Team A", "team_a_logo.png",
                "Team B", "team_b_logo.png");
        List<MatchesResponseDTO> matches = Arrays.asList(match1, match2);

        when(matchScheduleService.getAllMatches()).thenReturn(matches);

        // when & then
        mvc.perform(get("/matches")
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.data[0].matchDate").value("2024-04-12"))
                .andExpect(jsonPath("$.data[0].matchTime").value("20:00"))
                .andExpect(jsonPath("$.data[0].matchState").value("In Progress"))
                .andExpect(jsonPath("$.data[0].matchTitle").value("Football Match"))
                .andExpect(jsonPath("$.data[0].homeTeamScore").value("2"))
                .andExpect(jsonPath("$.data[0].awayTeamScore").value("1"))
                .andExpect(jsonPath("$.data[0].homeTeamName").value("Home Team"))
                .andExpect(jsonPath("$.data[0].homeTeamLogo").value("home_team_logo.png"))
                .andExpect(jsonPath("$.data[0].awayTeamName").value("Away Team"))
                .andExpect(jsonPath("$.data[0].awayTeamLogo").value("away_team_logo.png"))
                .andExpect(jsonPath("$.data[1].matchDate").value("2024-04-13"))
                .andExpect(jsonPath("$.data[1].matchTime").value("15:30"))
                .andExpect(jsonPath("$.data[1].matchState").value("Scheduled"))
                .andExpect(jsonPath("$.data[1].matchTitle").value("Basketball Game"))
                .andExpect(jsonPath("$.data[1].homeTeamScore").value("0"))
                .andExpect(jsonPath("$.data[1].awayTeamScore").value("0"))
                .andExpect(jsonPath("$.data[1].homeTeamName").value("Team A"))
                .andExpect(jsonPath("$.data[1].homeTeamLogo").value("team_a_logo.png"))
                .andExpect(jsonPath("$.data[1].awayTeamName").value("Team B"))
                .andExpect(jsonPath("$.data[1].awayTeamLogo").value("team_b_logo.png"));

    }
}
