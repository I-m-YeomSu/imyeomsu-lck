package imyeom_lck.predict.domain.dto;

import imyeom_lck.predict.domain.entity.VotedUser;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VotedUserDTO {
    private int year;
    private int month;
    private Long predictId;
    private Long memberId;
    private boolean flag;

    public static VotedUserDTO fromEntity(VotedUser votedUser){
        return VotedUserDTO.builder()
                .year(votedUser.getYear())
                .month(votedUser.getMonth())
                .predictId(votedUser.getPredictId())
                .memberId(votedUser.getMemberId())
                .flag(votedUser.isFlag())
                .build();
    }
}
