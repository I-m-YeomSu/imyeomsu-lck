package imyeom_lck.common.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.news.domain.NewsDTO;
import imyeom_lck.news.service.NewsService;
import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {

    private final NewsService newsService;
    private final RankService rankService;

    @GetMapping("/")
    public String indexForm(Model model) throws JsonProcessingException {
        PageRequest pageRequest = PageRequest.of(0,9);

        Page<NewsDTO> newsDTOPage = newsService.getPageAllNews(pageRequest);

        //뉴스 3개만 가져오기
        Map<LocalDate, List<NewsDTO>> newsMap = newsService.getNews();
        log.info("newMap -> {}", newsMap.size());

        // Localdate 역순으로 newsList 저장
        Map<LocalDate, List<NewsDTO>> reversedNewsMap = new TreeMap<>(Comparator.reverseOrder());
        reversedNewsMap.putAll(newsMap);

        List<NewsDTO> newsThree = new ArrayList<>();
        int i =0;
        for (List<NewsDTO> value : newsMap.values()) {
            if (i == 3){
                break;
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
        List<RankDTO> rankList = rankService.getRank();
        rankList = rankService.rankSort(rankList);
        model.addAttribute("ranking", rankList);

        return "main/index";
    }

    private Map<LocalDate, List<NewsDTO>> getReversedNewsMap() throws JsonProcessingException {
        Map<LocalDate, List<NewsDTO>> newsMap = newsService.getNews();

        // newsMap의 LocalDate를 역순으로 정렬
        Map<LocalDate, List<NewsDTO>> reversedNewsMap = new TreeMap<>(Comparator.reverseOrder());
        reversedNewsMap.putAll(newsMap);
        return reversedNewsMap;

    }



}
