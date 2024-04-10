 package imyeom_lck.match_schedule.service.impl;


 import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
 import imyeom_lck.match_schedule.domain.dto.NextMatchResponseDTO;
 import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
 import imyeom_lck.match_schedule.persistence.jpa.JpaMatchScheduleRepository;
 import imyeomsu.lck.common_utils.code.ErrorCode;
 import imyeomsu.lck.common_utils.exception.ClientException;
 import lombok.RequiredArgsConstructor;
 import org.springframework.stereotype.Service;

 import imyeom_lck.match_schedule.service.inter.MatchScheduleService;

 import java.time.LocalDateTime;
 import java.util.ArrayList;
 import java.util.List;

 @Service
 @RequiredArgsConstructor
 public class MatchScheduleServiceImpl implements MatchScheduleService {

     private final JpaMatchScheduleRepository matchRepository;

     public List<MatchesResponseDTO> getAllMatches() {

         List<MatchesResponseDTO> matchesResponseDTOS = new ArrayList<>();
         List<MatchSchedule> matchSchedules = matchRepository.findAll();

         for (MatchSchedule matchSchedule : matchSchedules) {
             matchesResponseDTOS.add(MatchesResponseDTO.fromEntity(matchSchedule));
         }


         return matchesResponseDTOS;
     }

 }
