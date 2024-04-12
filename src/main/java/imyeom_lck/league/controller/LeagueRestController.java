package imyeom_lck.league.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.domain.entity.Rank;
import imyeom_lck.league.service.inter.LeagueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.event.WindowFocusListener;
import java.util.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/leagues")
public class LeagueRestController {

    private final LeagueService leagueService;

    @GetMapping("/getrank")
    public List<RankDTO> getrank() {
        List<RankDTO> rankList = leagueService.redistest();

        rankList = leagueService.ranksort(rankList);

        return rankList;
    }

    @GetMapping("/getnews")
    public List<NewsDTO> getnews(){
        List<NewsDTO> newsList = leagueService.getNews();

        return newsList;
    }



}
