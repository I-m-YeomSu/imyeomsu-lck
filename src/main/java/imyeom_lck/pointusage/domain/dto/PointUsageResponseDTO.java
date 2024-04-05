package imyeom_lck.pointusage.domain.dto;

import imyeom_lck.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointUsageResponseDTO {

    private Member member;

    //포인트분류군
    private Long usageClassification;

    //포인트날짜
    private LocalDateTime usageDate;

    //포인트사용내역
    private String pointHistory;

}
