package imyeom_lck.league.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.league.service.inter.LeagueService;
import imyeom_lck.news.domain.NewsDTO;
import imyeom_lck.news.service.NewsService;
import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.league.dummy.DummyNewsDTO;
import imyeom_lck.league.dummy.DummyRankDTO;
import imyeom_lck.rank.domain.entity.Rank;
import imyeom_lck.rank.service.RankService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LeagueRestController.class)
public class LeagueRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NewsService newsService;


    @MockBean
    private RankService rankService;

    private RankDTO rankDTO1;
    private RankDTO rankDTO2;
    private NewsDTO newsDTO1;
    private NewsDTO newsDTO2;

    private List<RankDTO> rankList;
    private List<NewsDTO> newsList;

    private Map<LocalDate, List<NewsDTO>> newsMap;

    private LocalDate currentDate;

    @BeforeEach
    void setUp(){

        rankDTO1 = DummyRankDTO.dummy("team1", "logo1", 111);
        rankDTO2 = DummyRankDTO.dummy("team2", "logo2", 222);

        rankList = new ArrayList<>();
        rankList.add(rankDTO1);
        rankList.add(rankDTO2);

        newsDTO1 = DummyNewsDTO.dummy("title1", "content1");
        newsDTO2 = DummyNewsDTO.dummy("title2", "content2");

        newsList = new ArrayList<>();
        newsList.add(newsDTO1);
        newsList.add(newsDTO2);

        currentDate = LocalDate.of(2024, 4, 17);

        newsMap = new TreeMap<>();
        newsMap.put(currentDate, newsList);

    }

    @DisplayName("랭킹 가져오기")
    @Test
    public void testRank() throws Exception {
        given(rankService.getRank()).willReturn(rankList);
        given(rankService.rankSort(rankList)).willReturn(rankList);

        mvc.perform(get("/api/leagues/getrank").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].name").value("team1"))
                .andExpect(jsonPath("$.data[1].name").value("team2"));

    }

    @DisplayName("뉴스 가져오기")
    @Test
    public void testNews() throws JsonProcessingException, Exception {
        given(newsService.getNews()).willReturn(newsMap);

        mvc.perform(get("/api/leagues/getnews").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data['2024-04-17'][0].title").value("title1"))
                .andExpect(jsonPath("$.data['2024-04-17'][0].content").value("content1"));

    }

}
