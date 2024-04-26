package imyeom_lck.predict.domain.dto;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.predict.domain.entity.Predict;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class PredictDTO {

    private Long homeTeamVote;

    private Long awayTeamVote;

    private int year;

    private int month;

    private Long predictIndex;

    public static PredictDTO fromEntity(Predict predict){
        return PredictDTO.builder()
                .homeTeamVote(predict.getHomeTeamVote())
                .awayTeamVote(predict.getAwayTeamVote())
                .month(predict.getMonth())
                .year(predict.getYear())
                .predictIndex(predict.getPredictIndex())
                .build();
    }

}
