package imyeom_lck.member.domain.dto;

import imyeom_lck.member.domain.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetailsResponseDTO {

    @Schema(description = "유저 아이디", example = "loginId")
    private String loginId;

    @Schema(description = "유저 이름", example = "memberName")
    private String memberName;

    @Schema(description = "핸드폰번호", example = "memberPhone")
    private String memberPhone;

    @Schema(description = "비밀번호", example = "memberPassword")
    private String memberPassword;

    @Schema(description = "응원팀", example = "cheeringTeam")
    private String cheeringTeam;

    @Schema(description = "유저 알람", example = "true")
    private boolean isAlert;

    @Schema(description = "보유포인트", example = "memberPoint")
    private int memberPoint;

    @Schema(description = "유저 삭제상태", example = "false")
    private boolean isDeleted;

    public static MemberDetailsResponseDTO fromEntity(Member member){
        return MemberDetailsResponseDTO.builder()
                .loginId(member.getLoginId())
                .memberName(member.getName())
                .memberPhone(member.getPhoneNumber())
                .memberPassword(member.getPassword())
                .memberPoint(member.getPoint())
                .cheeringTeam(member.getCheeringTeam())
                .isAlert(member.isAlert())
                .isDeleted(member.isDeleted())
                .build();
    }
}

