package imyeom_lck.common.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {

    private final LeagueService leagueService;

    @GetMapping("/event/main")
    public String mainEventForm(){
        return "fragments/event/event-main-fragment";
    }


    @GetMapping("/main")
    public String main(){
        return "fragments/main/main-wrapper";
    }

    @GetMapping("/")
    public String indexForm(Model model) throws JsonProcessingException {
        PageRequest pageRequest = PageRequest.of(0,9);

        Page<NewsDTO> newsDTOPage = leagueService.getPageAllNews(pageRequest);


        //뉴스 3개만 가져오기
        Map<LocalDate, List<NewsDTO>> newsMap = leagueService.getnews();
        // Localdate 역순으로 newsList 저장
        Map<LocalDate, List<NewsDTO>> reversedNewsMap = new TreeMap<>(Comparator.reverseOrder());
        reversedNewsMap.putAll(newsMap);

        List<NewsDTO> newsThree = new ArrayList<>();
        int i =0;
        for (List<NewsDTO> value : reversedNewsMap.values()) {
            if (i == 3){
                break;
            }

            if (value.get(i).getThumbnail().equals("No image URL found")){
                continue;
            }

            NewsDTO newsDTO = value.get(i);
            newsThree.add(newsDTO);
            i++;
        }
        log.info("news count!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! {}", newsThree.size());
        model.addAttribute("newsThree", newsThree);
        //뉴스를 레디스에 저장된 값을 불러옵니다.
        model.addAttribute("newsList", newsDTOPage);


        //팀랭킹
        List<RankDTO> rankList = leagueService.getrank();
        rankList = leagueService.ranksort(rankList);
        model.addAttribute("ranking", rankList);

        return "main/index";
    }

    private Map<LocalDate, List<NewsDTO>> getReversedNewsMap() throws JsonProcessingException {
        Map<LocalDate, List<NewsDTO>> newsMap = leagueService.getnews();

        // newsMap의 LocalDate를 역순으로 정렬
        Map<LocalDate, List<NewsDTO>> reversedNewsMap = new TreeMap<>(Comparator.reverseOrder());
        reversedNewsMap.putAll(newsMap);
        return reversedNewsMap;

    }

    @GetMapping("/hot-time")
    public String test(){

        return "fragments/event/hot-time-event";
    }



}
