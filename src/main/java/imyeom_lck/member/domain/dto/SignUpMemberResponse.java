package imyeom_lck.member.domain.dto;

import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.role.domain.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpMemberResponse {

    @Schema(description = "유저 아이디", example = "loginId")
    private String loginId;

    @Schema(description = "유저 이름", example = "memberName")
    private String memberName;

    @Schema(description = "핸드폰 번호", example = "memberPhone")
    private String memberPhone;

    @Schema(description = "비밀번호", example = "memberPassword")
    private String memberPassword;

    @Schema(description = "응원팀", example = "cheeringTeam")
    private String cheeringTeam;

    @Schema(description = "유저 알람", example = "true")
    private boolean isAlert;

    @Schema(description = "보유포인트", example = "memberPoint")
    private int memberPoint;

    @Schema(description = "유저 삭제 상태", example = "false")
    private boolean isDeleted;

    @Schema(description = "유저 권한 상태", example = "ROLE_USER")
    private String roleName;

    public static SignUpMemberResponse fromEntity(Member member, Role role){
        return SignUpMemberResponse.builder()
                .loginId(member.getLoginId())
                .memberName(member.getName())
                .memberPhone(member.getPhoneNumber())
                .memberPassword(member.getPassword())
                .memberPoint(member.getPoint())
                .cheeringTeam(member.getCheeringTeam())
                .isAlert(member.isAlert())
                .isDeleted(member.isDeleted())
                .roleName(role.getName())
                .build();
    }

}
