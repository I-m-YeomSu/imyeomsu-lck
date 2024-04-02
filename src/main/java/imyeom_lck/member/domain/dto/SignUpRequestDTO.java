package imyeom_lck.member.domain.dto;

import imyeom_lck.pointusage.domain.entity.PointUsage;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequestDTO {

    @Schema(description = "유저 아이디", example = "loginId")
    private String loginId;

    @Schema(description = "유저 비밀 번호", example = "password")
    private String password;

    @Schema(description = "유저 이름", example = "name")
    private String name;

    @Schema(description = "유저 핸드폰 번호", example = "01012341234")
    private String phoneNumber;

}
