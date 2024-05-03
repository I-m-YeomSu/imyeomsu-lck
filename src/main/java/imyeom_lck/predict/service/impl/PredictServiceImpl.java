package imyeom_lck.predict.service.impl;

import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeom_lck.predict.domain.dto.PredictDTO;
import imyeom_lck.predict.domain.dto.PredictRequestDTO;
import imyeom_lck.predict.domain.dto.VotedUserDTO;
import imyeom_lck.predict.domain.entity.Predict;
import imyeom_lck.predict.domain.entity.VotedUser;
import imyeom_lck.predict.persistence.jpa.PredictAllCountRepository;
import imyeom_lck.predict.persistence.jpa.PredictCountRepository;
import imyeom_lck.predict.persistence.jpa.PredictRepository;
import imyeom_lck.predict.persistence.jpa.VotedUserRepository;
import imyeom_lck.predict.service.inter.PredictService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PredictServiceImpl implements PredictService {

    private final PredictCountRepository predictCountRepository;
    private final PredictAllCountRepository predictAllCountRepository;
    private final PredictRepository predictRepository;
    private final VotedUserRepository votedUserRepository;

    @Override
    public PredictDTO vote(PredictRequestDTO predictRequestDTO) throws InterruptedException {

        Long appliedUser = predictCountRepository.add(predictRequestDTO.getPredictId(), predictRequestDTO.getMemberId());
        Long appliedUserAll = predictAllCountRepository.add(predictRequestDTO.getMemberId());

//        LocalDate currentDate = LocalDate.now();
        // 5월 경기가 없으니까 4월로지정
        LocalDate currentDate = LocalDate.of(2024, 4, 31);

        log.info("applyuser:{} {}", appliedUser, appliedUserAll);

        if(appliedUserAll==1){
            predictAllCountRepository.increment();
        }

        Optional<Predict> optionalPredict = predictRepository.findByPredictIndex(predictRequestDTO.getPredictId());
        Predict predict;
        if (optionalPredict.isPresent()) {
            predict = optionalPredict.get();
        } else {
            predict = Predict.builder()
                    .homeTeamVote(0L)
                    .awayTeamVote(0L)
                    .month(currentDate.getMonthValue())
                    .year(currentDate.getYear())
                    .predictIndex(predictRequestDTO.getPredictId())
                    .build();
            predict = predictRepository.save(predict);
        }

        log.info("predict:{}", predict.getPredictId());

        if(appliedUser != 1){
            return PredictDTO.fromEntity(predict);
        }

        log.info("count:{}", predict.getHomeTeamVote());

        if(predictRequestDTO.isFlag()){ // 홈
            Long homeVote = predict.getHomeTeamVote()+1;
            predict.setHomeTeamVote(homeVote);
        }
        else{ //어웨이
            Long awayVote = predict.getAwayTeamVote()+1;
            predict.setAwayTeamVote(awayVote);
        }

        log.info("count:{}", predict.getHomeTeamVote());

        VotedUser votedUser = VotedUser.builder()
                .year(currentDate.getYear())
                .month(currentDate.getMonthValue())
                .predictId(predictRequestDTO.getPredictId())
                .memberId(predictRequestDTO.getMemberId())
                .flag(predictRequestDTO.isFlag())
                .build();

        votedUserRepository.save(votedUser);

        predictRepository.save(predict);

        return PredictDTO.fromEntity(predict);
    }

    public List<VotedUserDTO> getVotedUserList(Long memberId){
        List<VotedUser> votedUserList = votedUserRepository.findByMemberId(memberId);

        List<VotedUserDTO> returnList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for(VotedUser votedUser : votedUserList){
            if(currentDate.getYear()==votedUser.getYear() && currentDate.getMonthValue()==votedUser.getMonth()){
                returnList.add(VotedUserDTO.fromEntity(votedUser));
            }
        }

        return returnList;
    }


}
