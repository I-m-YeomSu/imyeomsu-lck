package imyeom_lck.member.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetailsResponseDTO {

    private String memberName;
    private String memberPhone;
    private String memberPassword;
    private String cheeringTeam;
    private String pushAlert;
    private int memberPoint;
}

