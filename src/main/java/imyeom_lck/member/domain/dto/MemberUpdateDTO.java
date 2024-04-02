package imyeom_lck.member.domain.dto;

import imyeom_lck.pointusage.domain.entity.PointUsage;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberUpdateDTO {

    @Column(nullable = false)
    private String loginId;

    private String password;

    private String name;

    private String phoneNumber;

    private String cheeringTeam;


}
