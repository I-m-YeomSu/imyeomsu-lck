package imyeom_lck.league.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
@RequestMapping(value = "/api/leagues")
@RequiredArgsConstructor
public class LeagueRestController {

    private final LeagueService leagueService;

    @GetMapping("/getrank")
    public List<RankDTO> getrank() {
        List<RankDTO> rankList = leagueService.redistest();

        rankList = leagueService.ranksort(rankList);

        return rankList;
    }

    @GetMapping("/getnews")
    public List<NewsDTO> getnews() throws JsonProcessingException {


        List<NewsDTO> newsList = leagueService.getnews();
//        newsList = leagueService.ranksort(newsList);

        return newsList;
    }



}
