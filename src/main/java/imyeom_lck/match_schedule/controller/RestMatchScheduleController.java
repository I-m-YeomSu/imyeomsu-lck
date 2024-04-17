 package imyeom_lck.match_schedule.controller;

 import com.fasterxml.jackson.core.JsonProcessingException;
 import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
 import imyeom_lck.match_schedule.domain.dto.MatchesViewResponseDTO;
 import imyeom_lck.match_schedule.domain.dto.NextMatchResponseDTO;
 import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
 import imyeomsu.lck.common_utils.dto.ResponseDto;
 import lombok.RequiredArgsConstructor;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import java.util.List;

 @RestController
 @RequiredArgsConstructor
 @RequestMapping(value="/api/matches")
 public class RestMatchScheduleController {

     private final MatchScheduleService matchScheduleService;

     @GetMapping(value="/getAll")
     public ResponseEntity<ResponseDto<List<MatchesResponseDTO>>> getAllMatches() {
         List<MatchesResponseDTO> matchesResponseDTO = matchScheduleService.getAllMatches();

         return ResponseEntity.ok(ResponseDto.<List<MatchesResponseDTO>>builder()
                 .data(matchesResponseDTO)
                 .status(HttpStatus.OK)
                 .success(true)
                 .build());

     }
//
//     @GetMapping(value = "/matches/nextMatch")
//     public ResponseEntity<ResponseDto<NextMatchResponseDTO>> getNextMatch() {
//         NextMatchResponseDTO nextMatchResponseDTO = matchScheduleService.getNextMatch();
//
//
//         return ResponseEntity.ok(ResponseDto.<NextMatchResponseDTO>builder()
//                 .data(nextMatchResponseDTO)
//                 .status(HttpStatus.OK)
//                 .success(true)
//                 .build());
//     }

     @GetMapping(value="/getmatchschedule")
     public ResponseEntity<ResponseDto<List<MatchesViewResponseDTO>>> getAllMatcheSchedule() throws JsonProcessingException {
         List<MatchesViewResponseDTO> matchesResponseDTO = matchScheduleService.getAllMatcheSchedule();

         return ResponseEntity.ok(ResponseDto.<List<MatchesViewResponseDTO>>builder()
                 .data(matchesResponseDTO)
                 .status(HttpStatus.OK)
                 .success(true)
                 .build());

     }

 }
