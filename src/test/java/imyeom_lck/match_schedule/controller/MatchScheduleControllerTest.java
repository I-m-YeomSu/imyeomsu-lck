package imyeom_lck.match_schedule.controller;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
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
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestMatchScheduleController.class)
public class MatchScheduleControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MatchScheduleService matchScheduleService;

    @Test
    public void testGetAllMatches() throws Exception{
        MatchesResponseDTO match1 = new MatchesResponseDTO(1L, 2L, "2024-04-01T12:00:00", true, false);
        MatchesResponseDTO match2 = new MatchesResponseDTO(3L, 4L, "2024-04-02T12:00:00", false, true);
        List<MatchesResponseDTO> matches = Arrays.asList(match1, match2);

        when(matchScheduleService.getAllMatches()).thenReturn(matches);

        // when & then
        mvc.perform(get("/matches")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\"success\":true," +
                                "\"status\":200," +
                                "\"data\":[" +
                                "{\"homeTeam\":1," +
                                "\"awayTeam\":2," +
                                "\"matchDate\":\"2024-04-01T12:00:00\"," +
                                "\"matchResult\":true," +
                                "\"showdown\":false}," +
                                "{\"homeTeam\":3," +
                                "\"awayTeam\":4," +
                                "\"matchDate\":\"2024-04-02T12:00:00\"," +
                                "\"matchResult\":false," +
                                "\"showdown\":true}" +
                                "]," +
                                "\"errorMessages\":null}")
                );

    }
}
