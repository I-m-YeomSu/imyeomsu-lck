package imyeom_lck.rank.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.league.service.inter.LeagueService;
import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.rank.domain.dto.RankingDTO;
import imyeom_lck.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/ranks")
@Controller
@RequiredArgsConstructor
@Slf4j
public class RankingController {

	private final RankService rankService;

	@GetMapping("/ranking/reverse-ranking-fragment")
	public String getTeamRankingFragment(Model model, @RequestParam(name = "buttonName") String buttonName) throws JsonProcessingException {
		// 정렬 순서를 변경한 ranking 데이터 가져오기
		List<RankDTO> rank = rankService.getRank();
		log.info("----------------------------------- button name {} ", buttonName);
		if (buttonName.equals("asc-ranking")){
			List<RankingDTO> rankingDto = rankService.getRankingDto(rankService.rankSort(rank));
			model.addAttribute("ranking",rankingDto);

		} else if (buttonName.equals("desc-ranking")){

			log.info(buttonName.toString());
			List<RankingDTO> rankingDto = rankService.getRankingDto(rankService.rankSort(rank));
			Collections.reverse(rankingDto);
			model.addAttribute("ranking",rankingDto);

		}


		return "fragments/league/team-ranking-fragment";
	}



	@GetMapping("/all-ranking")
	public String getAllRanking(Model model) throws JsonProcessingException {

		List<RankDTO> rank = rankService.getRank();

		if (!rank.isEmpty()){

			List<RankingDTO> rankingDto = rankService.getRankingDto(rankService.rankSort(rank));
			model.addAttribute("ranking",rankingDto);
			return "schedule/ranking";
		}

		//이제 else로  해당 요청에 대한  RDB에서 데이터 찾아와서 처리 ㄱㄱ
		return "schedule/ranking";

	}

}
