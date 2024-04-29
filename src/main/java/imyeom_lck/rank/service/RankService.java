package imyeom_lck.rank.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.rank.domain.dto.RankingDTO;

public interface RankService {


	List<RankDTO> getRank() throws JsonProcessingException;
	List<RankDTO> rankSort(List<RankDTO> rankList);
	List<RankingDTO> getRankingDto(List<RankDTO> rankList);


}
