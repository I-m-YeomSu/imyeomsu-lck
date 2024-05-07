// package imyeom_lck.match_schedule.controller;
//
// import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
// import imyeom_lck.match_schedule.domain.dto.MatchesViewResponseDTO;
// import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
// import java.time.LocalDateTime;
// import java.util.Arrays;
// import java.util.List;
//
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
// @WebMvcTest(RestMatchScheduleController.class)
// public class MatchScheduleRestControllerTest {
//     @Autowired
//     private MockMvc mvc;
//
//     @MockBean
//     private MatchScheduleService matchScheduleService;
//
//     @Test
//     public void testGetAllMatches() throws Exception{
//         MatchesResponseDTO match1 = new MatchesResponseDTO("2024-04-12", "20:00", "In Progress", "Football Match",
//                 "2", "1", "Home Team", "home_team_logo.png",
//                 "Away Team", "away_team_logo.png");
//
//         // 데이터를 하드코딩하여 두 번째 객체 생성
//         MatchesResponseDTO match2 = new MatchesResponseDTO("2024-04-13", "15:30", "Scheduled", "Basketball Game",
//                 "0", "0", "Team A", "team_a_logo.png",
//                 "Team B", "team_b_logo.png");
//         List<MatchesResponseDTO> matches = Arrays.asList(match1, match2);
//
//         when(matchScheduleService.getAllMatchesByRedis()).thenReturn(matches);
//
//         // when & then
//         mvc.perform(get("/matches")
//                         .contentType(MediaType.APPLICATION_JSON)).andDo(print())
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.success").value(true))
//                 .andExpect(jsonPath("$.status").value(200))
//                 .andExpect(jsonPath("$.data[0].matchDate").value("2024-04-12"))
//                 .andExpect(jsonPath("$.data[0].matchTime").value("20:00"))
//                 .andExpect(jsonPath("$.data[0].matchState").value("In Progress"))
//                 .andExpect(jsonPath("$.data[0].matchTitle").value("Football Match"))
//                 .andExpect(jsonPath("$.data[0].homeTeamScore").value("2"))
//                 .andExpect(jsonPath("$.data[0].awayTeamScore").value("1"))
//                 .andExpect(jsonPath("$.data[0].homeTeamName").value("Home Team"))
//                 .andExpect(jsonPath("$.data[0].homeTeamLogo").value("home_team_logo.png"))
//                 .andExpect(jsonPath("$.data[0].awayTeamName").value("Away Team"))
//                 .andExpect(jsonPath("$.data[0].awayTeamLogo").value("away_team_logo.png"))
//                 .andExpect(jsonPath("$.data[1].matchDate").value("2024-04-13"))
//                 .andExpect(jsonPath("$.data[1].matchTime").value("15:30"))
//                 .andExpect(jsonPath("$.data[1].matchState").value("Scheduled"))
//                 .andExpect(jsonPath("$.data[1].matchTitle").value("Basketball Game"))
//                 .andExpect(jsonPath("$.data[1].homeTeamScore").value("0"))
//                 .andExpect(jsonPath("$.data[1].awayTeamScore").value("0"))
//                 .andExpect(jsonPath("$.data[1].homeTeamName").value("Team A"))
//                 .andExpect(jsonPath("$.data[1].homeTeamLogo").value("team_a_logo.png"))
//                 .andExpect(jsonPath("$.data[1].awayTeamName").value("Team B"))
//                 .andExpect(jsonPath("$.data[1].awayTeamLogo").value("team_b_logo.png"));
//
//     }
//
//     @DisplayName("getAllMatcheSchedule")
//     @Test
//     public void getSchedule() throws Exception {
//
//         LocalDateTime LDT = LocalDateTime.of(2024, 4, 17, 15, 30);
//         MatchesViewResponseDTO match1 = new MatchesViewResponseDTO.builder()
//             .matchDate("2024-05-07")
//             .matchTime("19:00")
//             .matchState("Ongoing")
//             .matchTitle("Football Match")
//             .homeTeamScore("2")
//             .awayTeamScore("1")
//             .homeTeamName("Home Team")
//             .homeTeamLogo("home_team_logo.png")
//             .awayTeamName("Away Team")
//             .awayTeamLogo("away_team_logo.png")
//             .build();
//
//         MatchesViewResponseDTO match2 = new MatchesViewResponseDTO.builder()
//             .matchDate("2024-05-07")
//             .matchTime("20:30")
//             .matchState("Scheduled")
//             .matchTitle("Basketball Game")
//             .homeTeamScore("0")
//             .awayTeamScore("0")
//             .homeTeamName("Team A")
//             .homeTeamLogo("team_a_logo.png")
//             .awayTeamName("Team B")
//             .awayTeamLogo("team_b_logo.png")
//             .build();
//
//         List<MatchesViewResponseDTO> matches = Arrays.asList(match1, match2);
//
//         when(matchScheduleService.getAllMatchSchedule()).thenReturn(matches);
//         mvc.perform(MockMvcRequestBuilders.get("/api/matches/getmatchschedule").contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.data[0].matchTitle").value("Football Match"));
//     }
//
// }
