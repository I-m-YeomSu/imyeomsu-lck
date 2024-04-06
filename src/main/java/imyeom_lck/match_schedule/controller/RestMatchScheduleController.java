package imyeom_lck.match_schedule.controller;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.dto.NextMatchResponseDTO;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import imyeomsu.lck.common_utils.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestMatchScheduleController {

    private final MatchScheduleService matchScheduleService;

    @GetMapping(value="/matches")
    public ResponseDto<List<MatchesResponseDTO>> getAllMatches() {
        List<MatchesResponseDTO> matchesResponseDTO = matchScheduleService.getAllMatches();

        return ResponseDto.<List<MatchesResponseDTO>>builder()
                .data(matchesResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build();


    }

    @GetMapping(value = "/matches/nextMatch")
    public ResponseDto<NextMatchResponseDTO> getNextMatch() {
        NextMatchResponseDTO nextMatchResponseDTO = matchScheduleService.getNextMatch();

        return ResponseDto.<NextMatchResponseDTO>builder()
                .data(nextMatchResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build();
    }
}
