package imyeom_lck.match_schedule.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NextMatchResponseDTO {

    private Long homeTeam;
    private Long awayTeam;
    private String matchDate;
    private boolean isShowdown;


    public static NextMatchResponseDTO createNextMatchResponseDTO(
            Long homeTeam,
            Long awayTeam,
            String matchDate,
            boolean isShowdown) {

        return NextMatchResponseDTO.builder()
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .matchDate(matchDate)
                .isShowdown(isShowdown)
                .build();
    }

}
