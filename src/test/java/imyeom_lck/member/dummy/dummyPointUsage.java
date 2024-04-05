package imyeom_lck.member.dummy;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.pointusage.domain.entity.PointUsage;

import java.time.LocalDateTime;

public class dummyPointUsage {

    public static PointUsage createPointUsage(Long usageClassification, Member member, LocalDateTime usageDate, String pointHistory){
        return PointUsage.builder()
                .usageClassification(usageClassification)
                .member(member)
                .usageDate(usageDate)
                .pointHistory(pointHistory)
                .build();
    }

}

