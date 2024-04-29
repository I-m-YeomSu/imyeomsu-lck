package imyeom_lck.league.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import imyeom_lck.rank.domain.entity.Rank;
import imyeom_lck.rank.service.RankService;
import imyeomsu.lck.common_utils.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

@RestController
@Slf4j
@RequestMapping(value = "/api/leagues")
@RequiredArgsConstructor
public class LeagueRestController {

    private final LeagueService leagueService;
    private final RankService rankService;

    @GetMapping("/getrank")
    public ResponseEntity<ResponseDto<List<RankDTO>>> getRank() throws JsonProcessingException {
        List<RankDTO> rankList = rankService.getRank();

        rankList = rankService.rankSort(rankList);

        return ResponseEntity.ok(ResponseDto.<List<RankDTO>>builder()
                .data(rankList)
                .status(HttpStatus.OK)
                .success(true)
                .build());
    }

    @GetMapping("/getnews")
    public ResponseEntity<ResponseDto<Map<LocalDate, List<NewsDTO>>>> getnews() throws JsonProcessingException {

        Map<LocalDate, List<NewsDTO>> newsMap = leagueService.getNews();

        return ResponseEntity.ok(ResponseDto.<Map<LocalDate, List<NewsDTO>>>builder()
                .data(newsMap)
                .status(HttpStatus.OK)
                .success(true)
                .build());
    }



}
