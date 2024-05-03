package imyeom_lck.common.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import imyeom_lck.auth.service.CustomUserDetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    // 최신 정보를 redis에서 가져옵니다. 또한 해당 정보가 redis에 없ㄷ
    @GetMapping("/")
    public String indexForm(Model model, HttpSession session) throws JsonProcessingException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("index {} {}", authentication.getClass().getName(),authentication.getName());


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
            if (i == 7){
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

        log.info("{}", rankList.get(1).getTeamName());
        // 있으면 레디스꺼 ! 없다면 RDB
        if(rankList.isEmpty()){
            rankList = rankService.getRanks();
        }

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
