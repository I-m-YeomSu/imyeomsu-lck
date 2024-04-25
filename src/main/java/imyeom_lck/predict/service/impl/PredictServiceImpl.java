package imyeom_lck.predict.service.impl;

import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.predict.domain.dto.PredictDTO;
import imyeom_lck.predict.domain.dto.PredictRequestDTO;
import imyeom_lck.predict.domain.entity.Predict;
import imyeom_lck.predict.persistence.jpa.PredictAllCountRepository;
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
    private final PredictAllCountRepository predictAllCountRepository;
    private final PredictRepository predictRepository;

    @Override
    public PredictDTO vote(PredictRequestDTO predictRequestDTO) throws InterruptedException {

        Long appliedUser = predictCountRepository.add(predictRequestDTO.getPredictId(), predictRequestDTO.getMemberId());
        Long appliedUserAll = predictAllCountRepository.add(predictRequestDTO.getMemberId());

        log.info("applyuser:{} {}", appliedUser, appliedUserAll);

        if(appliedUserAll==1){
            predictAllCountRepository.increment();
        }

        Predict predict = predictRepository.findById(predictRequestDTO.getPredictId()).orElseThrow();
        log.info("predict:{}", predict.getPredictId());

        if(appliedUser != 1){
            return PredictDTO.fromEntity(predict);
        }

        if(predictRequestDTO.isFlag()){ // 홈
            Long homeVote = predict.getHomeTeamVote()+1;
            predict.setHomeTeamVote(homeVote);
        }
        else{ //어웨이
            Long awayVote = predict.getAwayTeamVote()+1;
            predict.setAwayTeamVote(awayVote);
        }

        predictRepository.save(predict);

        return PredictDTO.fromEntity(predict);
    }

}
