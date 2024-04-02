package imyeom_lck.member.domain.dto;

import imyeom_lck.pointusage.domain.entity.PointUsage;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDTO {

    private Long memberId;

    private String loginId;

    private String password;

    private String name;

    private String phoneNumber;

}
