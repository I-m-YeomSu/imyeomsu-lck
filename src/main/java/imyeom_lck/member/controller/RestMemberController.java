package imyeom_lck.member.controller;


import imyeom_lck.common.domain.dto.ResponseDto;
import imyeom_lck.common.exception.ClientException;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestMemberController {

    private final MemberServiceImpl memberService;

    @GetMapping(value="/members/details/{memberId}")
    public ResponseDto<MemberDetailsResponseDTO> getMemberDetails(@PathVariable Long memberId) {

        MemberDetailsResponseDTO MemberDetailsResponseDTO = memberService.getMemberDetails(memberId);

        return ResponseDto.<imyeom_lck.member.domain.dto.MemberDetailsResponseDTO>builder()
                .data(MemberDetailsResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build();
    }

    @GetMapping(value = "/members/{loginId}")
    public Long getMemberId(@PathVariable String loginId) {
        try {
            return memberService.findByLoginId(loginId);
        } catch (ClientException e) {
            return null;
        }
    }
}
