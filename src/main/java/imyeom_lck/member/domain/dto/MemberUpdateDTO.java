package imyeom_lck.member.domain.dto;

import imyeom_lck.pointusage.domain.entity.PointUsage;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberUpdateDTO {

    @Schema(description = "유저 아이디", example = "loginId")
    @Column(nullable = false)
    private String loginId;

    @Schema(description = "유저 비밀번호", example = "password")
    private String password;

    @Schema(description = "유저 이름", example = "name")
    private String name;

    @Schema(description = "핸드폰번호", example = "phoneNumber")
    private String phoneNumber;

    @Schema(description = "응원팀", example = "cheeringTeam")
    private String cheeringTeam;


}
