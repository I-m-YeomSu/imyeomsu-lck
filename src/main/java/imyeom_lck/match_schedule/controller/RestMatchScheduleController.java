package imyeom_lck.match_schedule.controller;


import imyeom_lck.common.domain.dto.ResponseDto;
import imyeom_lck.common.exception.ClientException;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.service.inter.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestMatchScheduleController {

    private final MatchScheduleService matchScheduleService;

    @GetMapping(value="/matches")
    public ResponseEntity<ResponseDto<List<MatchesResponseDTO>>> getAllMatches() {
        List<MatchesResponseDTO> matchesResponseDTO = matchScheduleService.getAllMatches();

        ResponseDto<List<MatchesResponseDTO>> response = ResponseDto.<List<MatchesResponseDTO>>builder()
                .data(matchesResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build();

        return ResponseEntity.ok(response);
    }
}
