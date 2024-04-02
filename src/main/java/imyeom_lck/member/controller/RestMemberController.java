package imyeom_lck.member.controller;


import imyeom_lck.common.domain.dto.ResponseDto;
import imyeom_lck.common.exception.ClientException;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.domain.entity.SignUpRequest;
import imyeom_lck.member.service.impl.MemberServiceImpl;
import imyeom_lck.member.service.inter.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/members")
@Slf4j
public class RestMemberController {

    private final MemberService memberService;

    @GetMapping(value="/details/{memberId}")
    public ResponseDto<MemberDetailsResponseDTO> getMemberDetails(@PathVariable Long memberId) {

        MemberDetailsResponseDTO MemberDetailsResponseDTO = memberService.getMemberDetails(memberId);

        return ResponseDto.<imyeom_lck.member.domain.dto.MemberDetailsResponseDTO>builder()
                .data(MemberDetailsResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build();
    }

    @GetMapping(value = "/{loginId}")
    public Long getMemberId(@PathVariable String loginId) {
        try {
            return memberService.findByLoginId(loginId);
        } catch (ClientException e) {
            return null;
        }
    }

    //회원가입
    @PostMapping(value = "/signUp")
    public Member signUp(SignUpRequestDTO signUpRequestDTO){

        return memberService.signUp(signUpRequestDTO);
    }


    //삭제
    @PostMapping(value = "/delete")
    public Member deleteMember(Long memberId){

        return memberService.deleteMember(memberId);
    }


    //업데이트
    @PostMapping(value = "/update")
    public Member updateMember(Long memberId, MemberUpdateDTO memberUpdateDTO){
        return memberService.updateMember(memberId, memberUpdateDTO);
    }

}
