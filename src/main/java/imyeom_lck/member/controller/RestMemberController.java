package imyeom_lck.member.controller;


import imyeom_lck.common.code.ErrorCode;
import imyeom_lck.common.domain.dto.ResponseDto;
import imyeom_lck.common.exception.ClientException;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.service.inter.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "MemberController", description = "회원관련 API")
@RequiredArgsConstructor
@RequestMapping(value = "/members")
@Slf4j
public class RestMemberController {

    private final MemberService memberService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "게시글 조회 성공", content = @Content(schema = @Schema(implementation = MemberDetailsResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    @Operation(summary = "memberId 로 회원찾기")
    @GetMapping(value="/details/{memberId}")
    public ResponseDto<MemberDetailsResponseDTO> getMemberDetails(@Parameter(name = "id", description = "posts 의 id", in = ParameterIn.PATH) @Valid @PathVariable Long memberId) {

        MemberDetailsResponseDTO MemberDetailsResponseDTO = memberService.getMemberDetails(memberId);

        return ResponseDto.<imyeom_lck.member.domain.dto.MemberDetailsResponseDTO>builder()
                .data(MemberDetailsResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build();
    }

    @Operation(summary = "loginId 로 회원찾기")
    @GetMapping(value = "/{loginId}")
    public Long getMemberId(@Valid @PathVariable String loginId) {
        try {
            return memberService.findByLoginId(loginId);
        } catch (ClientException e) {
            return null;
        }
    }

    @Operation(summary = "회원가입")
    @PostMapping(value = "/signUp")
    public ResponseDto<MemberDetailsResponseDTO> signUp(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO){

        return ResponseDto.<MemberDetailsResponseDTO>builder()
                .data(memberService.signUp(signUpRequestDTO))
                .status(HttpStatus.OK)
                .success(true)
                .build();
    }


    @Operation(summary = "memberId 로 회원삭제")
    @PostMapping(value = "/delete")
    public ResponseDto<MemberDetailsResponseDTO> deleteMember(@Valid @PathVariable("memberId") Long memberId){

        MemberDetailsResponseDTO memberDetailsResponseDTO = memberService.deleteMember(memberId);

        return ResponseDto.<MemberDetailsResponseDTO>builder()
                .data(memberDetailsResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build();
    }


    @Operation(summary = "회원 업데이트")
    @PostMapping(value = "/update/{id}")
    public ResponseDto<MemberDetailsResponseDTO> updateMember (@Valid @PathVariable("id") Long id, @RequestBody  MemberUpdateDTO memberUpdateDTO){

        MemberDetailsResponseDTO memberDetailsResponseDTO = memberService.updateMember(id, memberUpdateDTO);

        return ResponseDto.<MemberDetailsResponseDTO>builder()
                .data(memberDetailsResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build();
    }

}
