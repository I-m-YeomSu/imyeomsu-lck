package imyeom_lck.member.domain.dto;

import imyeom_lck.pointusage.domain.entity.PointUsage;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdateDTO {

    @Column(nullable = false)
    private String loginId;

    private String password;

    private String name;

    private String phoneNumber;

    private String cheeringTeam;

    private boolean isAlert;

}
