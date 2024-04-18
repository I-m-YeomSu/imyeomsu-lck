package imyeom_lck.predict.service.impl;

import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.predict.domain.dto.PredictDTO;
import imyeom_lck.predict.domain.dto.PredictRequestDTO;
import imyeom_lck.predict.domain.entity.Predict;
import imyeom_lck.predict.persistence.jpa.PredictCountRepository;
import imyeom_lck.predict.persistence.jpa.PredictRepository;
import imyeom_lck.predict.service.inter.PredictService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PredictServiceImpl implements PredictService {

    private final PredictCountRepository predictCountRepository;
    private final PredictRepository predictRepository;

    @Override
    public PredictDTO vote(PredictRequestDTO predictRequestDTO) throws InterruptedException {

        log.info("lg:{}{}{}",predictRequestDTO.getPredictId(), predictRequestDTO.getMemberId(), predictRequestDTO.isFlag());
        Long appliedUser = predictCountRepository.add(predictRequestDTO.getMemberId());

        Predict predict = predictRepository.findById(predictRequestDTO.getPredictId()).orElseThrow();

        if(appliedUser != 1){
            return PredictDTO.fromEntity(predict);
        }

        long count = predictRepository.count();

        if(predictRequestDTO.isFlag()){ // 홈
            Long homeVote = count + predict.getHomeTeamVote();
            predict.setHomeTeamVote(homeVote);
        }
        else{ //어웨이
            Long awayVote = count + predict.getAwayTeamVote();
            predict.setAwayTeamVote(awayVote);
        }

        predictRepository.save(predict);

        return PredictDTO.fromEntity(predict);
    }

}
